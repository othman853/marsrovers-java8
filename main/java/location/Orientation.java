package location;


public enum Orientation {

    SOUTH("S", true, -1) {
        Orientation left() {return WEST;}
        Orientation right() {return EAST;}
    },
    WEST("W", false, -1) {
        Orientation left() {return SOUTH;}
        Orientation right() {return NORTH;}
    },
    NORTH("N", true, +1) {
        Orientation left() {return WEST;}
        Orientation right() {return EAST;}
    },
    EAST("E", false, +1) {
        Orientation left() {return NORTH;}
        Orientation right() {return SOUTH;}
    };


    private String string;
    private boolean isVertical;
    private int move;

    Orientation(String string, boolean isVertical, int move) {
        this.string = string;
        this.isVertical = isVertical;
        this.move = move;
    }

    boolean isVertical() {
        return isVertical;
    }

    int move() {
        return move;
    }

    @Override
    public String toString() {
        return this.string;
    }

    abstract Orientation left();
    abstract Orientation right();

}
