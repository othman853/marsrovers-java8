package com.marsrovers.location

import org.junit.Test
import com.marsrovers.units.Rover

import java.util.Optional

import junit.framework.TestCase.assertFalse
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

class PlateauTest {


    @Test
    @Throws(Exception::class)
    fun shouldContainBoundaries() {

        val plateau = Plateau(10, 10)

        assertEquals(10, plateau.horizontalBoundary.toLong())
        assertEquals(10, plateau.verticalBoundary.toLong())

    }

    @Test(expected = IllegalArgumentException::class)
    @Throws(Exception::class)
    fun shouldNotCreatePlateauWithoutHorizontalBoundary() {
        Plateau(0, 10)
    }


    @Test(expected = IllegalArgumentException::class)
    @Throws(Exception::class)
    fun shouldNotCreatePlateauWithoutVerticalBoundary() {
        Plateau(10, 0)
    }


    @Test
    @Throws(Exception::class)
    fun shouldSetANewRoverToThePlateu() {

        val rover = Rover("a", Orientation.NORTH, Position(1, 1))
        val plateau = Plateau(10, 10)

        plateau.set(rover)

        assertTrue(plateau.isOccupied(rover))
        assertEquals(rover, plateau["a"].get())
    }

    @Test
    @Throws(Exception::class)
    fun shouldAInformThatThePositionIsFree() {
        val rover = Rover("a", Orientation.NORTH, Position(1, 1))
        val plateau = Plateau(10, 10)

        plateau.set(rover)
        val actualResponse = plateau.isOccupied(Rover("a", Orientation.EAST, Position(2, 2)))

        assertFalse(actualResponse)
    }

    @Test
    @Throws(Exception::class)
    fun shouldAInformThatThePositionIsFreeInAnEmptyPositionsList() {
        val plateau = Plateau(10, 10)

        val actualResponse = plateau.isOccupied(Rover("a", Orientation.EAST, Position(2, 2)))

        assertFalse(actualResponse)
    }

    @Test
    @Throws(Exception::class)
    fun getInexistentRoverShouldReturnEmptyOptional() {
        val plateau = Plateau(10, 10)

        val rover = plateau["whatever"]

        assertFalse(rover.isPresent)

    }
}
