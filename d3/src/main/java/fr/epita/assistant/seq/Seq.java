package fr.epita.assistant.seq;

import java.lang.reflect.Type;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public interface Seq<T> extends ExtendedStream<T> {


    static <TYPE> Seq<TYPE> of(List<TYPE> values) {
        return values::stream;
    }

    static <TYPE> Seq<TYPE> of(TYPE... values) {
        return () -> Stream.of(values);
    }

    static <TYPE> Seq<TYPE> of(Stream<TYPE> values) {
        return () -> values;
    }


    Stream<T> delegate();



    @Override
    default <KEY_TYPE> Map<KEY_TYPE, T> toMap(final Function<T, KEY_TYPE> keyMapper) {
        return toMap(new HashMap<KEY_TYPE, T>(), keyMapper, Function.identity());
    }

    @Override
    default <KEY_TYPE, VALUE_TYPE, MAP_TYPE extends Map<KEY_TYPE, VALUE_TYPE>> MAP_TYPE toMap(final MAP_TYPE map, final Function<T, KEY_TYPE> keyMapper, final Function<T, VALUE_TYPE> valueMapper) {
        forEach(elt -> map.put(keyMapper.apply(elt), valueMapper.apply(elt)));
        return map;
    }

    @Override
    default <KEY_TYPE, VALUE_TYPE> Map<KEY_TYPE, VALUE_TYPE> toMap(final Function<T, KEY_TYPE> keyMapper, final Function<T, VALUE_TYPE> valueMapper) {
        return toMap(new HashMap<KEY_TYPE, VALUE_TYPE>(), keyMapper, valueMapper);
    }

    @Override
    default List<T> toList() {
        return this.collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    default <LIST extends List<T>> LIST toList(final LIST list) {
        for (var elt : this.toList()) {
            list.add(elt);
        }
        return list;
    }

    @Override
    default Set<T> toSet() {
        return this.collect(Collectors.toSet());
    }

    @Override
    default <SET extends Set<T>> SET toSet(final SET set) {
        for (var elt : this.toSet()) {
            set.add(elt);
        }
        return set;
    }

    @Override
    default <ASSOCIATED_TYPE> ExtendedStream<Pair<T, ASSOCIATED_TYPE>> associate(final Supplier<ASSOCIATED_TYPE> supplier) {
        ArrayList list = new ArrayList();
        forEach(elt -> list.add(new Pair<T, ASSOCIATED_TYPE>(elt, supplier.get())));
        return Seq.of(list);
    }

    @Override
    default <ASSOCIATED_TYPE> ExtendedStream<Pair<T, ASSOCIATED_TYPE>> associate(final Stream<ASSOCIATED_TYPE> supplier) {
        List l2 = supplier.toList();
        List l1 = this.toList();
        List res = new ArrayList();
        int min = 0;
        if (l1.size() > l2.size())
        {
            min = l2.size();
        }
        else
        {
            min = l1.size();
        }
        for (int i = 0; i < min; i++)
        {
            res.add(new Pair<>(l1.get(i), l2.get(i)));
        }
        return Seq.of(res);
    }

    @Override
    default ExtendedStream<T> print() {
        this.forEach(System.out::println);
        return this;
    }

    @Override
    default ExtendedStream<T> plus(final Stream<T> stream) {
        return Seq.of(Stream.concat(this, stream));
    }

    //TODO: changer ces merdes

    @Override
    default Object join(final String delimiter) {
        StringBuilder stringBuilder = new StringBuilder();
        forEach(elt -> stringBuilder.append(elt).append(delimiter));
        return stringBuilder.substring(0, stringBuilder.length() - delimiter.length());
    }

    @Override
    default String join() {
        StringBuilder stringBuilder = new StringBuilder();
        forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    @Override
    default <KEY_TYPE> ExtendedStream<Pair<KEY_TYPE, ExtendedStream<T>>> partition(final Function<T, KEY_TYPE> pivot) {
        return Seq.of(map(pivot).map(e -> new Pair<>(e, Seq.of(filter(elt -> pivot.apply(elt).equals(e))))));
    }

    @Override
    default Stream<T> filter(Predicate<? super T> predicate) {
        return delegate().filter(predicate);
    }

    @Override
    default <R> Stream<R> map(Function<? super T, ? extends R> function) {
        return delegate().map(function);
    }

    @Override
    default IntStream mapToInt(ToIntFunction<? super T> toIntFunction) {
        return delegate().mapToInt(toIntFunction);
    }

    @Override
    default LongStream mapToLong(ToLongFunction<? super T> toLongFunction) {
        return delegate().mapToLong(toLongFunction);
    }

    @Override
    default DoubleStream mapToDouble(ToDoubleFunction<? super T> toDoubleFunction) {
        return delegate().mapToDouble(toDoubleFunction);
    }

    @Override
    default <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> function) {
        return delegate().flatMap(function);
    }

    @Override
    default IntStream flatMapToInt(Function<? super T, ? extends IntStream> function) {
        return delegate().flatMapToInt(function);
    }

    @Override
    default LongStream flatMapToLong(Function<? super T, ? extends LongStream> function) {
        return delegate().flatMapToLong(function);
    }

    @Override
    default DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> function) {
        return delegate().flatMapToDouble(function);
    }

    @Override
    default Stream<T> distinct() {
        return delegate().distinct();
    }

    @Override
    default Stream<T> sorted() {
        return delegate().sorted();
    }

    @Override
    default Stream<T> sorted(Comparator<? super T> comparator) {
        return delegate().sorted(comparator);
    }

    @Override
    default Stream<T> peek(Consumer<? super T> consumer) {
        return delegate().peek(consumer);
    }

    @Override
    default Stream<T> limit(long l) {
        return delegate().limit(l);
    }

    @Override
    default Stream<T> skip(long l) {
        return delegate().skip(l);
    }

    @Override
    default void forEach(Consumer<? super T> consumer) {
        delegate().forEach(consumer);
    }

    @Override
    default void forEachOrdered(Consumer<? super T> consumer) {
        forEachOrdered(consumer);
    }

    @Override
    default Object[] toArray() {
        return delegate().toArray();
    }

    @Override
    default <A> A[] toArray(IntFunction<A[]> intFunction) {
        return delegate().toArray(intFunction);
    }

    @Override
    default T reduce(T t, BinaryOperator<T> binaryOperator) {
        return delegate().reduce(t, binaryOperator);
    }

    @Override
    default Optional<T> reduce(BinaryOperator<T> binaryOperator) {
        return delegate().reduce(binaryOperator);
    }

    @Override
    default <U> U reduce(U u, BiFunction<U, ? super T, U> biFunction, BinaryOperator<U> binaryOperator) {
        return delegate().reduce(u, biFunction, binaryOperator);
    }

    @Override
    default <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> biConsumer, BiConsumer<R, R> biConsumer1) {
        return delegate().collect(supplier, biConsumer, biConsumer1);
    }

    @Override
    default <R, A> R collect(Collector<? super T, A, R> collector) {
        return delegate().collect(collector);
    }

    @Override
    default Optional<T> min(Comparator<? super T> comparator) {
        return delegate().min(comparator);
    }

    @Override
    default Optional<T> max(Comparator<? super T> comparator) {
        return delegate().max(comparator);
    }

    @Override
    default long count() {
        return delegate().count();
    }

    @Override
    default boolean anyMatch(Predicate<? super T> predicate) {
        return delegate().anyMatch(predicate);
    }

    @Override
    default boolean allMatch(Predicate<? super T> predicate) {
        return delegate().allMatch(predicate);
    }

    @Override
    default boolean noneMatch(Predicate<? super T> predicate) {
        return delegate().noneMatch(predicate);
    }

    @Override
    default Optional<T> findFirst() {
        return delegate().findFirst();
    }

    @Override
    default Optional<T> findAny() {
        return delegate().findAny();
    }

    @Override
    default Iterator<T> iterator() {
        return delegate().iterator();
    }

    @Override
    default Spliterator<T> spliterator() {
        return delegate().spliterator();
    }

    @Override
    default boolean isParallel() {
        return delegate().isParallel();
    }

    @Override
    default Stream<T> sequential() {
        return delegate().sequential();
    }

    @Override
    default Stream<T> parallel() {
        return delegate().parallel();
    }

    @Override
    default Stream<T> unordered() {
        return delegate().unordered();
    }

    @Override
    default Stream<T> onClose(Runnable runnable) {
        return delegate().onClose(runnable);
    }

    @Override
    default void close() {
        delegate().close();
    }
}
