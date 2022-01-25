package fr.epita.assistant.game.food;

public class CookedSteak extends Food implements Cookable {
    public CookedSteak()
    {
        this.name = "Cooked Steak";
        this.calories = 20;
    }

    @Override
    public Food cook() {
        return new BurnedSteak();
    }
}
