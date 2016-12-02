package location;

public class Position {

    private static final int SINGLE_MOVE = 1;

    final int x;
    final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position right() {
        return new Position(x + SINGLE_MOVE, y);
    }

    public Position left() {
        return new Position(x - SINGLE_MOVE, y);
    }

    public Position up() {
        return new Position(x, y + SINGLE_MOVE);
    }

    public Position down() {
        return new Position(x, y - SINGLE_MOVE);
    }
}
