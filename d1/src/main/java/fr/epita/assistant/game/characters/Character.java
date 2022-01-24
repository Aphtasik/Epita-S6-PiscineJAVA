package fr.epita.assistant.game.characters;

public abstract class Character {
    // Attributes
    protected String name;
    protected int health;
    protected boolean isAlive;
    protected int armour;

    // Get set
    public String getName() {
        return this.name;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        }
        else {
            this.health = health;
        }
    }

    public int getHealth() {
        return this.health;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean getIsAlive() {
        return this.isAlive;
    }

    public void setArmour(int armour) {
        if (armour < 0) {
            this.armour = 0;
        }
        else {
            this.armour = armour;
        }
    }

    public int getArmour() {
        return this.armour;
    }

    // Constructor
    public Character(String name, int health, int armour) {
        setArmour(armour);
        setHealth(health);
        setIsAlive(true);
        this.name = name;
    }

    // Methodes
    public boolean isDead() {
        return !isAlive;
    }

    public abstract void printStats();
    public abstract int getDamage();
    public abstract void takeDamage(int damage);
}
