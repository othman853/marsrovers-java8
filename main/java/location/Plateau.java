package location;

import units.Rover;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

    final int horizontalBoundary;
    final int verticalBoundary;
    private final List<Rover> rovers = new ArrayList<>();

    Plateau(int horizontalBoundary, int verticalBoundary) {

        if(horizontalBoundary <= 0) {
            throw new IllegalArgumentException("Horizontal Boundary must be grater than 0");
        }

        if(verticalBoundary <= 0) {
            throw new IllegalArgumentException("Vertical Boundary must be grater than 0");
        }

        this.horizontalBoundary = horizontalBoundary;
        this.verticalBoundary = verticalBoundary;
    }

    public void add(Rover rover) {
        rovers.add(rover);
    }

    public boolean isOccupied(final Position position) {
        return rovers
                .stream()
                .anyMatch(rover-> rover.location.position.x == position.x && rover.location.position.y == position.y);
    }
}
