package location;


import java.util.Arrays;
import java.util.Optional;

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
    public final boolean isVertical;
    public final int move;

    Orientation(String string, boolean isVertical, int move) {
        this.string = string;
        this.isVertical = isVertical;
        this.move = move;
    }

    public static Orientation fromString(String orientation) {
        Optional<Orientation> orientationOptional =
                Arrays
                .stream(values())
                .filter( o -> o.string.equals(orientation))
                .findFirst();

        if (!orientationOptional.isPresent()) {
            throw new IllegalArgumentException("Orientation " + orientation + " does not exists");
        }

        return orientationOptional.get();
    }

    @Override
    public String toString() {
        return this.string;
    }

    public abstract Orientation left();
    public abstract Orientation right();

}
