package units;


import location.Orientation;
import location.Position;

public class Rover {

    public final String id;
    public final Orientation orientation;
    public final Position position;


    public Rover(String id, Orientation orientation, Position position) {
        this.id = id;
        this.orientation = orientation;
        this.position = position;
    }

    public Rover left() {
        return new Rover(id, orientation.left(), position);
    }


    public Rover right() {
        return new Rover(id, orientation.right(), position);
    }

    public Rover move() {

        return (orientation.isVertical)
                ? new Rover(id, orientation, position.moveY(orientation.move))
                : new Rover(id, orientation, position.moveX(orientation.move));
    }

    @Override
    public String toString() {
        return String.join(" ", id, position.toString(), orientation.toString());
    }
}
