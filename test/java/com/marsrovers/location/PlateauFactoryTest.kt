package com.marsrovers.location


import org.junit.Test

import org.junit.Assert.assertEquals

class PlateauFactoryTest {

    internal var factory = PlateauFactory()

    @Test
    @Throws(Exception::class)
    fun defaultShouldCreateA10by10Plateau() {

        val plateau = factory.createDefaultPlateau()

        assertEquals(10, plateau.horizontalBoundary.toLong())
        assertEquals(10, plateau.verticalBoundary.toLong())

    }
}
