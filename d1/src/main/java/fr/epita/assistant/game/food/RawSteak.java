package fr.epita.assistant.game.food;

public class RawSteak extends Food implements Cookable {
    public RawSteak()
    {
        this.name = "Raw Steak";
        this.calories = 15;
    }

    @Override
    public Food cook() {
        return new CookedSteak();
    }
}
