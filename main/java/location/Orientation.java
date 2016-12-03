package location;


public enum Orientation {

    SOUTH("S", true, -1) {
        public Orientation left() {return WEST;}
        public Orientation right() {return EAST;}
    },
    WEST("W", false, -1) {
        public Orientation left() {return SOUTH;}
        public Orientation right() {return NORTH;}
    },
    NORTH("N", true, +1) {
        public Orientation left() {return WEST;}
        public Orientation right() {return EAST;}
    },
    EAST("E", false, +1) {
        public Orientation left() {return NORTH;}
        public Orientation right() {return SOUTH;}
    };


    private String string;
    private boolean isVertical;
    private int move;

    Orientation(String string, boolean isVertical, int move) {
        this.string = string;
        this.isVertical = isVertical;
        this.move = move;
    }

    public boolean isVertical() {
        return isVertical;
    }

    public int move() {
        return move;
    }

    @Override
    public String toString() {
        return this.string;
    }

    public abstract Orientation left();
    public abstract Orientation right();

}
