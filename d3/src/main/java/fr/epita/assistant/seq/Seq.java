package fr.epita.assistant.seq;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public interface Seq<ELEMENT_TYPE> extends ExtendedStream<ELEMENT_TYPE> {
    @Override
    default <KEY_TYPE> Map<KEY_TYPE, ELEMENT_TYPE> toMap(final Function<ELEMENT_TYPE, KEY_TYPE> keyMapper) {
        return null;
    }

    @Override
    default <KEY_TYPE, VALUE_TYPE, MAP_TYPE extends Map<KEY_TYPE, VALUE_TYPE>> MAP_TYPE toMap(final MAP_TYPE map, final Function<ELEMENT_TYPE, KEY_TYPE> keyMapper, final Function<ELEMENT_TYPE, VALUE_TYPE> valueMapper) {
        return null;
    }

    @Override
    default <KEY_TYPE, VALUE_TYPE> Map<KEY_TYPE, VALUE_TYPE> toMap(final Function<ELEMENT_TYPE, KEY_TYPE> keyMapper, final Function<ELEMENT_TYPE, VALUE_TYPE> valueMapper) {
        return null;
    }

    @Override
    default List<ELEMENT_TYPE> toList() {
        return null;
    }

    @Override
    default <LIST extends List<ELEMENT_TYPE>> LIST toList(final LIST list) {
        return null;
    }

    @Override
    default Set<ELEMENT_TYPE> toSet() {
        return null;
    }

    @Override
    default <SET extends Set<ELEMENT_TYPE>> SET toSet(final SET set) {
        return null;
    }

    @Override
    default <ASSOCIATED_TYPE> ExtendedStream<Pair<ELEMENT_TYPE, ASSOCIATED_TYPE>> associate(final Supplier<ASSOCIATED_TYPE> supplier) {
        return null;
    }

    @Override
    default <ASSOCIATED_TYPE> ExtendedStream<Pair<ELEMENT_TYPE, ASSOCIATED_TYPE>> associate(final Stream<ASSOCIATED_TYPE> supplier) {
        return null;
    }

    @Override
    default ExtendedStream<ELEMENT_TYPE> print() {
        return null;
    }

    @Override
    default ExtendedStream<ELEMENT_TYPE> plus(final Stream<ELEMENT_TYPE> stream) {
        return null;
    }

    @Override
    default Object join(final String delimiter) {
        return null;
    }

    @Override
    default String join() {
        return null;
    }

    @Override
    default <KEY_TYPE> ExtendedStream<Pair<KEY_TYPE, ExtendedStream<ELEMENT_TYPE>>> partition(final Function<ELEMENT_TYPE, KEY_TYPE> pivot) {
        return null;
    }

    @Override
    default Stream<ELEMENT_TYPE> filter(Predicate<? super ELEMENT_TYPE> predicate) {
        return null;
    }

    @Override
    default <R> Stream<R> map(Function<? super ELEMENT_TYPE, ? extends R> function) {
        return null;
    }

    @Override
    default IntStream mapToInt(ToIntFunction<? super ELEMENT_TYPE> toIntFunction) {
        return null;
    }

    @Override
    default LongStream mapToLong(ToLongFunction<? super ELEMENT_TYPE> toLongFunction) {
        return null;
    }

    @Override
    default DoubleStream mapToDouble(ToDoubleFunction<? super ELEMENT_TYPE> toDoubleFunction) {
        return null;
    }

    @Override
    default <R> Stream<R> flatMap(Function<? super ELEMENT_TYPE, ? extends Stream<? extends R>> function) {
        return null;
    }

    @Override
    default IntStream flatMapToInt(Function<? super ELEMENT_TYPE, ? extends IntStream> function) {
        return null;
    }

    @Override
    default LongStream flatMapToLong(Function<? super ELEMENT_TYPE, ? extends LongStream> function) {
        return null;
    }

    @Override
    default DoubleStream flatMapToDouble(Function<? super ELEMENT_TYPE, ? extends DoubleStream> function) {
        return null;
    }

    @Override
    default Stream<ELEMENT_TYPE> distinct() {
        return null;
    }

    @Override
    default Stream<ELEMENT_TYPE> sorted() {
        return null;
    }

    @Override
    default Stream<ELEMENT_TYPE> sorted(Comparator<? super ELEMENT_TYPE> comparator) {
        return null;
    }

    @Override
    default Stream<ELEMENT_TYPE> peek(Consumer<? super ELEMENT_TYPE> consumer) {
        return null;
    }

    @Override
    default Stream<ELEMENT_TYPE> limit(long l) {
        return null;
    }

    @Override
    default Stream<ELEMENT_TYPE> skip(long l) {
        return null;
    }

    @Override
    default void forEach(Consumer<? super ELEMENT_TYPE> consumer) {

    }

    @Override
    default void forEachOrdered(Consumer<? super ELEMENT_TYPE> consumer) {

    }

    @Override
    default Object[] toArray() {
        return new Object[0];
    }

    @Override
    default <A> A[] toArray(IntFunction<A[]> intFunction) {
        return null;
    }

    @Override
    default ELEMENT_TYPE reduce(ELEMENT_TYPE element_type, BinaryOperator<ELEMENT_TYPE> binaryOperator) {
        return null;
    }

    @Override
    default Optional<ELEMENT_TYPE> reduce(BinaryOperator<ELEMENT_TYPE> binaryOperator) {
        return Optional.empty();
    }

    @Override
    default <U> U reduce(U u, BiFunction<U, ? super ELEMENT_TYPE, U> biFunction, BinaryOperator<U> binaryOperator) {
        return null;
    }

    @Override
    default <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super ELEMENT_TYPE> biConsumer, BiConsumer<R, R> biConsumer1) {
        return null;
    }

    @Override
    default <R, A> R collect(Collector<? super ELEMENT_TYPE, A, R> collector) {
        return null;
    }

    @Override
    default Optional<ELEMENT_TYPE> min(Comparator<? super ELEMENT_TYPE> comparator) {
        return Optional.empty();
    }

    @Override
    default Optional<ELEMENT_TYPE> max(Comparator<? super ELEMENT_TYPE> comparator) {
        return Optional.empty();
    }

    @Override
    default long count() {
        return 0;
    }

    @Override
    default boolean anyMatch(Predicate<? super ELEMENT_TYPE> predicate) {
        return false;
    }

    @Override
    default boolean allMatch(Predicate<? super ELEMENT_TYPE> predicate) {
        return false;
    }

    @Override
    default boolean noneMatch(Predicate<? super ELEMENT_TYPE> predicate) {
        return false;
    }

    @Override
    default Optional<ELEMENT_TYPE> findFirst() {
        return Optional.empty();
    }

    @Override
    default Optional<ELEMENT_TYPE> findAny() {
        return Optional.empty();
    }

    @Override
    default Iterator<ELEMENT_TYPE> iterator() {
        return null;
    }

    @Override
    default Spliterator<ELEMENT_TYPE> spliterator() {
        return null;
    }

    @Override
    default boolean isParallel() {
        return false;
    }

    @Override
    default Stream<ELEMENT_TYPE> sequential() {
        return null;
    }

    @Override
    default Stream<ELEMENT_TYPE> parallel() {
        return null;
    }

    @Override
    default Stream<ELEMENT_TYPE> unordered() {
        return null;
    }

    @Override
    default Stream<ELEMENT_TYPE> onClose(Runnable runnable) {
        return null;
    }

    @Override
    default void close() {

    }
}
