package com.marsrovers.units

import com.marsrovers.location.Orientation
import com.marsrovers.location.Position
import org.junit.Test
import org.junit.Assert.assertEquals

class RoverTest {

    private val roverId = "a"
    private val rover = Rover(roverId, Orientation.NORTH, Position(1, 1))


    @Test
    @Throws(Exception::class)
    fun roverShouldMoveOrientationLeft() {

        val newRover = rover.left()

        assertEquals(Orientation.WEST, newRover.orientation)

    }

    @Test
    @Throws(Exception::class)
    fun locationShouldMoveOrientationRight() {

        val newRover = rover.right()

        assertEquals(Orientation.EAST, newRover.orientation)

    }

    @Test
    @Throws(Exception::class)
    fun locationShouldMovePositionUp() {

        val newRover = rover.move()

        assertEquals(2, newRover.position.y.toLong())

    }

    @Test
    @Throws(Exception::class)
    fun locationShouldMovePositionDown() {

        val rover = Rover(roverId, Orientation.SOUTH, Position(1, 1))

        val newRover = rover.move()

        assertEquals(0, newRover.position.y.toLong())

    }

    @Test
    @Throws(Exception::class)
    fun toStringShouldBeCorrect() {
        val asString = rover.toString()

        assertEquals("a " + rover.position.toString() + " " + rover.orientation.toString(), asString)

    }
}