package com.marsrovers.location;

public class PlateauFactory {

    private static final int DEFAULT_HORIZONTAL_SIZE = 10;
    private static final int DEFAULT_VERTICAL_SIZE = 10;

    public Plateau createDefaultPlateau() {
        return new Plateau(DEFAULT_HORIZONTAL_SIZE, DEFAULT_VERTICAL_SIZE);
    }

}
