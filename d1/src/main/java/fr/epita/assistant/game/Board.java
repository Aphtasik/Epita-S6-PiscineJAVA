package fr.epita.assistant.game;

public class Board {

    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Board(int size) {
        this.size = size;
    }

    public String printBoard() {
        var stringBuilder = new StringBuilder("");

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size - 1; j++)
            {
                stringBuilder.append("/ ");
            }
            stringBuilder.append('/');
        }
        return stringBuilder.toString();
    }
}
