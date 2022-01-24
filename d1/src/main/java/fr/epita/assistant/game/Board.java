package fr.epita.assistant.game;

import fr.epita.assistant.game.characters.Player;
import fr.epita.assistant.game.characters.Wizard;
import fr.epita.assistant.game.utils.Coord;
import fr.epita.assistant.game.utils.Direction;

public class Board {

    private int size;
    private Player player;
    private Wizard wizard;

    public Wizard getWizard() {
        return wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // TODO: add player ?
    public Board(int size, Player player, Wizard wizard) {
        setSize(size);
        setPlayer(player);
        setWizard(wizard);
    }

    public String printBoard() {
        var stringBuilder = new StringBuilder("");
        int isFull = 0;

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size - 1; j++)
            {
                stringBuilder.append("| ");

                if (wizard.getCoord().getX() == i && wizard.getCoord().getY() == j)
                {
                    stringBuilder.append("W");
                    isFull = 1;
                }
                if (player.getCoord().getX() == i && player.getCoord().getY() == j)
                {
                    stringBuilder.append("P");
                    isFull = 1;
                }

                if (isFull == 0)
                {
                    stringBuilder.append("  ");
                }
                else
                {
                    stringBuilder.append(" ");
                }
                isFull = 0;
            }
            stringBuilder.append("|\n");
        }
        return stringBuilder.toString();
    }

    public boolean movePlayer(Direction direction)
    {
        if (direction == Direction.UP)
        {
            if (player.getCoord().getX() - 1 >= 0)
            {
                player.move(Direction.UP);
                System.out.println("You moved to " + player.getCoord().toString());
                return true;
            }
            else
            {
                System.out.println("You can't move there!");
            }
        }
        else if (direction == Direction.DOWN)
        {
            if (player.getCoord().getX() + 1 <= size - 1)
            {
                player.move(Direction.DOWN);
                System.out.println("You moved to " + player.getCoord().toString());
                return true;
            }
            else
            {
                System.out.println("You can't move there!");
            }
        }
        else if (direction == Direction.LEFT)
        {
            if (player.getCoord().getY() - 1 >= 0)
            {
                player.move(Direction.LEFT);
                System.out.println("You moved to " + player.getCoord().toString());
                return true;
            }
            else
            {
                System.out.println("You can't move there!");
            }
        }
        else
        {
            if (player.getCoord().getY() + 1 <= size - 1)
            {
                player.move(Direction.RIGHT);
                System.out.println("You moved to " + player.getCoord().toString());
                return true;
            }
            else
            {
                System.out.println("You can't move there!");
            }
        }
        return false;
    }
}
