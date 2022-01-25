package fr.epita.assistant.game.characters;

public abstract class Monster extends Character implements Attacker {
    protected int damage;
    protected String name;

    @Override
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage > 0)
        {
            this.damage = damage;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void attack(Character character) {
        System.out.println(name + " attacks " + character.name);
    }

    @Override
    public void printStats() {
        System.out.println("Health: " + this.health);
        System.out.println("Damage: " + this.damage);
        System.out.println("Armour: " + this.armour);
    }

    @Override
    public void takeDamage(int damage) {
        System.out.println(getName() + " takes " + damage + " damage");
        setHealth(getHealth() - damage - 1);
        setArmour(getArmour() - 1);

        if (isDead())
        {
            System.out.println(getName() + " is dead");
        }
    }

    @Override
    public String toString() {
        return "M";
    }
}
