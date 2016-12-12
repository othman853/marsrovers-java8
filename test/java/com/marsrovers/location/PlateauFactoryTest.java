package com.marsrovers.location;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlateauFactoryTest {

    PlateauFactory factory = new PlateauFactory();

    @Test
    public void defaultShouldCreateA10by10Plateau() throws Exception {

        Plateau plateau = factory.createDefaultPlateau();

        assertEquals(10, plateau.horizontalBoundary);
        assertEquals(10, plateau.verticalBoundary);

    }
}
