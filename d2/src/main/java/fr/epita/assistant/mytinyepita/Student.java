package fr.epita.assistant.mytinyepita;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student extends Person implements Observable<Student>, Observer<Newsgroup> {
    protected int energy;
    protected Status status;
    protected Set<Observer<Student>> observers;

    @Override
    public Set<Observer<Student>> getObservers() {
        return observers;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if (energy <= 0)
        {
            this.energy = 0;
            setStatus(Status.TIRED);
        }
        else
        {
            this.energy = energy;
            setStatus(Status.OK);
        }
    }

    public Student(final String login, final int energy) {
        this.login = login;
        this.energy = energy;
        this.status = Status.OK;
        observers = new HashSet<>();
    }

    @Override
    public void register(Observer<Student>... observers) {
        this.observers.addAll(List.of(observers));
    }

    @Override
    public void unregister(Observer<Student> observer) {
        observers.remove(observer);
    }

    @Override
    public void fire(Student event) {
        this.observers.forEach(obs->obs.onEvent(event));
    }

    @Override
    public void postNews(Newsgroup newsgroup, String message) {
        if (!newsgroup.observers.contains(this))
        {
            throw new IllegalArgumentException("Student cannot post in a newsgroup he is not subscribed to.");
        }
        newsgroup.postNews(this, message);
    }

    @Override
    public void onEvent(Newsgroup event) {
        System.out.println(login + " reads the news.");
    }

    public void subscribeToNewsgroup(Newsgroup newsgroup)
    {
        newsgroup.register(this);
    }

    public void unsubscribeToNewsgroup(Newsgroup newsgroup)
    {
        if (!newsgroup.observers.contains(this))
        {
            throw new IllegalArgumentException("Student is not subscribed to this newsgroup.");
        }
        newsgroup.unregister(this);
    }

    public void work()
    {
        if (isAvailable())
        {
            throw new IllegalStateException("Student must be in a room to work.");
        }
        else if (this.getStatus().equals(Status.TIRED) && !this.getLogin().equals("peter.parker"))
        {
            throw new IllegalStateException(this.login + " is too tired to work.");
        }
        else
        {
            System.out.println(this.login + " is working.");
            setEnergy(getEnergy() - 1);
        }
    }

    public void goToSleep()
    {
        if (!this.isAvailable())
        {
            throw new IllegalStateException("Student must leave the room before going to sleep.");
        }
        setEnergy(5);
    }

    public void askForHelp()
    {
        if (observers.isEmpty())
        {
            System.out.println(this.login + " wishes he could be helped...");
        }
        else
        {
            if (getStatus().equals(Status.OK))
            {
                setStatus(Status.ASKING_FOR_HELP);
            }
            System.out.println(this.login + " is asking for help.");
            fire(this);
        }
    }
}
