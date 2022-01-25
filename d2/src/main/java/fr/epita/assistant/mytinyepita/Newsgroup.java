package fr.epita.assistant.mytinyepita;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Newsgroup implements Observable<Newsgroup> {
    protected String name;
    protected Set<Observer<Newsgroup>> observers;

    public String getName() {
        return name;
    }

    @Override
    public Set<Observer<Newsgroup>> getObservers() {
        return observers;
    }

    public Newsgroup(final String name) {
        this.name = name;
        observers = new HashSet<>();
    }

    @Override
    public void register(Observer<Newsgroup>... observers) {
        this.observers.addAll(List.of(observers));
    }

    @Override
    public void unregister(Observer<Newsgroup> observer) {
        observers.remove(observer);
    }

    public void fire(Newsgroup event) {
        this.observers.forEach(obs->obs.onEvent(event));
    }

    public void postNews(final Person person, final String message)
    {
        System.out.println(person.getLogin() + " sends a news in " + this.getName() + ".");
        System.out.println("Message: " + message);
        // TODO: fire(event) 1.3.3
        fire(this);
    }
}
