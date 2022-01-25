public class Pen {
    private static int penCounter;
    private static int redPenCounter;
    private static int bluePenCounter;

    private enum Color {
        RED,
        BLUE
    }

    private Color color;

    public Pen(final Color color)
    {
        this.color = color;
    }

    public static int getPenCounter() {
        return penCounter;
    }

    public static int getBluePenCounter() {
        return bluePenCounter;
    }

    public static int getRedPenCounter() {
        return redPenCounter;
    }

    public void print()
    {
        System.out.println("I'm a " + color + " pen");
    }
}
