package fr.epita.assistant.game.utils;

import java.util.Objects;

public class Coord {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        if (x >= 0)
        {
            this.x = x;
        }
    }

    public void setY(int y) {
        if (y >= 0)
        {
            this.y = y;
        }
    }

    public Coord(int x, int y) {
        if (x < 0)
        {
            this.x = 0;
        }
        else
        {
            this.x = x;
        }

        if (y < 0)
        {
            this.y = 0;
        }
        else
        {
            this.y = y;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return getX() == coord.getX() && getY() == coord.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        return "(" +
                "x=" + x +
                ", y=" + y +
                ')';
    }
}
