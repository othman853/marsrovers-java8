package location;

import units.Rover;

import java.util.HashMap;
import java.util.Map;

public class Plateau {

    final int horizontalBoundary;
    final int verticalBoundary;
    final Map<String, Rover> rovers = new HashMap<>();

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
        rovers.put(rover.id, rover);
    }

    boolean isOccupied(final Position position) {
        return rovers
                .entrySet()
                .stream()
                .anyMatch(es-> es.getValue().position.x == position.x && es.getValue().position.y == position.y);
    }

    void set(Rover rover) {
        rovers.put(rover.id, rover);
    }

    Rover get(String roverId) {
        return rovers.get(roverId);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        rovers.entrySet().forEach(es -> builder.append("[").append(es.getValue().toString()).append("]"));

        return builder.toString();

    }
}
