package fr.epita.assistant.game.characters;

import fr.epita.assistant.game.food.Food;
import fr.epita.assistant.game.utils.Coord;
import fr.epita.assistant.game.utils.Direction;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public final class Player extends Character implements Attacker {
    private int damage;
    private Coord coord;
    private ArrayList<Food> inventory;

    public ArrayList<Food> getInventory() {
        return inventory;
    }

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
        inventory = new ArrayList<Food>();
    }

    public void addFood(Food food)
    {
        inventory.add(food);
    }

    public Food takeFood(String foodName)
    {
        Food getFood = null;
        for (int i = 0; i < inventory.size(); i++)
        {
            if (inventory.get(i).getName().equals(foodName))
            {
               getFood = inventory.get(i);
               inventory.remove(i);
               break;
            }
        }
        return getFood;
    }

    public void eatFood(Food food)
    {
        takeFood(food.getName());
        this.setHealth(this.getHealth() + food.getCalories());
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
        if (!inventory.isEmpty())
        {
            System.out.println("Inventory:");
            for (int i = 0; i < inventory.size(); i++)
            {
                System.out.println(inventory.get(i).getName());
            }
        }
    }

    @Override
    public void takeDamage(int damage) {
        System.out.println("You take " + damage + " damage");
        setHealth(getHealth() - damage + (getArmour()/2));
        setArmour(getArmour() - 1);
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

    @Override
    public String toString() {
        return "P";
    }
}
