package fr.epita.assistant.game.food;

public abstract class Food {
    protected int calories;
    protected String name;

    public int getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "F";
    }
}
