package fr.epita.assistant.game.characters;

public class Coatlin extends Monster {
    public Coatlin()
    {
        setIsAlive(true);
        setHealth(100);
        setArmour(10);
        setDamage(10);
        setName("Coatlin");
    }

    @Override
    public void attack(Character character) {
        super.attack(character);
        character.takeDamage(getDamage() + (int)(0.1 * getHealth()));
    }
}
