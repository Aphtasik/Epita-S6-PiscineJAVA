package fr.epita.assistant.game.characters;

import fr.epita.assistant.game.utils.Coord;

public class Wizard extends Character {
    private int manaPoint;
    private Coord coord;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    @Override
    public void takeDamage(int damage) {
        System.out.println("Intelli Jee take " + damage + " damage");
        this.setHealth(getHealth() - damage);
        if (isDead())
        {
            System.out.println("Intelli Jee is dead");
        }
    }

    public int getDamage() {
        return 0;
    }

    public int getManaPoint() {
        return manaPoint;
    }

    public void setManaPoint(int manaPoint) {
        if (manaPoint <= 100 && manaPoint >= 0)
        {
            this.manaPoint = manaPoint;
        }
    }

    public Wizard(Coord coord)
    {
        this.coord = coord;
        setManaPoint(100);
        setHealth(100);
        setArmour(15);
        setIsAlive(true);
        this.name = "Intelli Jee";
    }

    @Override
    public void printStats() {
        System.out.println("Health: " + this.health);
        System.out.println("Damage: 0");
        System.out.println("Armour: " + this.armour);
        System.out.println("ManaPoint: " + this.manaPoint);
    }

    public void heal(Player player)
    {
        if (getManaPoint() < 20)
        {
            System.out.println("Intelli Jee doesn't have enough mana to heal");
        }
        else if (player.isDead())
        {
            System.out.println("You are dead, you can't be healed");
        }
        else if (player.getHealth() >= 100)
        {
            System.out.println("You already have the maximum health");
        }
        else
        {
            player.setHealth(player.getHealth() + 10);
            setManaPoint(getManaPoint() - 20);
            System.out.println("Intelli Jee healed you, you now have " + player.getHealth() + " health");
        }
    }

    public boolean enchant(Player player)
    {
        if (getManaPoint() < 15)
        {
            System.out.println("Intelli Jee doesn't have enough mana to use the Eclipse spell and enchant your weapon");
            return false;
        }
        else
        {
            player.setDamage(player.getDamage() + 20);
            setManaPoint(getManaPoint() - 15);
            System.out.println("Intelli Jee screams \"Eclipse !\" and enchant your weapon, you now deal " + player.getDamage() + " damage with each attack");
            return true;
        }

    }

    @Override
    public String toString() {
        return "W";
    }
}
