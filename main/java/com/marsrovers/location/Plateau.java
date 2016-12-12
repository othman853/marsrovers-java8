package com.marsrovers.location;

import com.marsrovers.units.Rover;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Plateau {

    final int horizontalBoundary;
    final int verticalBoundary;
    final Map<String, Rover> rovers = new HashMap<>();

    Plateau(int horizontalBoundary, int verticalBoundary) {

        if (horizontalBoundary <= 0) {
            throw new IllegalArgumentException("Horizontal Boundary must be grater than 0");
        }

        if (verticalBoundary <= 0) {
            throw new IllegalArgumentException("Vertical Boundary must be grater than 0");
        }

        this.horizontalBoundary = horizontalBoundary;
        this.verticalBoundary = verticalBoundary;
    }

    public boolean isOccupied(final Rover rover) {
        return rovers
                .entrySet()
                .stream()
                .anyMatch(es-> es.getValue().position.equals(rover.position));
    }

    public void set(Rover rover) {
        rovers.put(rover.id, rover);
    }

    public Optional<Rover> get(String roverId) {
        return Optional.ofNullable(rovers.get(roverId));
    }


    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        rovers.entrySet().forEach(es -> builder.append("[").append(es.getValue().toString()).append("]"));

        return builder.toString();

    }
}
