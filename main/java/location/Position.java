package location;

class Position {

    private static final int SINGLE_MOVE = 1;

    final int x;
    final int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Position moveX(int amount) {
        return new Position(x + amount, y);
    }

    Position moveY(int amount) {
        return new Position(x, y + amount);
    }
}
