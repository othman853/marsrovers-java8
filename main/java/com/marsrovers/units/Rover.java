package com.marsrovers.units;


import com.marsrovers.location.Orientation;
import com.marsrovers.location.Position;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (id != null ? !id.equals(rover.id) : rover.id != null) return false;
        if (orientation != rover.orientation) return false;
        return position != null ? position.equals(rover.position) : rover.position == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (orientation != null ? orientation.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
