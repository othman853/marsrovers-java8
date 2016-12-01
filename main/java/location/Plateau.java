package location;

import java.util.ArrayList;
import java.util.List;

class Plateau {

    final int horizontalBoundary;
    final int verticalBoundary;
    private final List<Position> occupiedPositions = new ArrayList<Position>();

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

    void add(Position position) {
        occupiedPositions.add(position);
    }

    boolean isOccupied(final Position position) {
        return occupiedPositions
                .stream()
                .anyMatch(occupiedPosition -> occupiedPosition.x == position.x && occupiedPosition.y == position.y);
    }
}
