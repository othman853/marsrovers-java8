package location;


public class Location {

    public final Orientation orientation;
    public final Position position;

    public Location(Orientation orientation, Position position) {
        this.orientation = orientation;
        this.position = position;
    }

    public Location left() {
        return new Location(orientation.left(), position);
    }


    public Location right() {
        return new Location(orientation.right(), position);
    }

    public Location move() {

        return (orientation.isVertical())
                ? new Location(orientation, position.moveY(orientation.move()))
                : new Location(orientation, position.moveX(orientation.move()));
    }



}
