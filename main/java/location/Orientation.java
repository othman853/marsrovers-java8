package location;


public enum Orientation {

    SOUTH("S") {
        Orientation left() {return WEST;}
        Orientation right() {return EAST;}
    },
    WEST("W") {
        Orientation left() {return SOUTH;}
        Orientation right() {return NORTH;}
    },
    NORTH("N") {
        Orientation left() {return WEST;}
        Orientation right() {return EAST;}
    },
    EAST("E") {
        Orientation left() {return NORTH;}
        Orientation right() {return SOUTH;}
    };


    private String string;

    Orientation(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return this.string;
    }

    abstract Orientation left();
    abstract Orientation right();

}
