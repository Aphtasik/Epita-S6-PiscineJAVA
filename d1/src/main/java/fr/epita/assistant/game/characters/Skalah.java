package fr.epita.assistant.game.characters;

public class Skalah extends Monster {
    public Skalah()
    {
        setIsAlive(true);
        setHealth(100);
        setArmour(10);
        setDamage(20);
        setName("Skalah");
    }

    @Override
    public void attack(Character character) {
        super.attack(character);
        character.takeDamage(getDamage() + 1);
    }
}
