package fr.epita.assistant.game.characters;

import fr.epita.assistant.game.utils.Coord;
import fr.epita.assistant.game.utils.Direction;

import java.lang.reflect.Constructor;

public final class Player extends Character implements Attacker {
    private int damage;
    private Coord coord;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public void setDamage(int damage) {
        if (damage > 0)
        {
            this.damage = damage;
        }
    }

    public int getDamage() {
        return damage;
    }

    public Player(Coord coord)
    {
        setCoord(coord);
        setHealth(100);
        setDamage(10);
        setArmour(15);
        setIsAlive(true);
        this.name = "Player";
    }

    @Override
    public void attack(Character character)
    {
        character.takeDamage(this.damage);
        setDamage(this.damage - 1);
    }

    @Override
    public void printStats() {
        System.out.println("Health: " + this.health);
        System.out.println("Damage: " + this.damage);
        System.out.println("Armour: " + this.armour);
    }

    @Override
    public void takeDamage(int damage) {
        System.out.println("You take" + damage + "damage");
        if (isDead())
        {
            System.out.println("You are dead");
        }
    }

    public void heal(int hp)
    {
        setHealth(this.health + hp);
    }

    public void move(Direction direction)
    {
        switch (direction)
        {
            case UP -> this.coord.setY(this.coord.getY() - 1);
            case DOWN -> this.coord.setY(this.coord.getY() + 1);
            case LEFT -> this.coord.setX(this.coord.getX() - 1);
            default -> this.coord.setX(this.coord.getX() + 1);
        }
    }
}
