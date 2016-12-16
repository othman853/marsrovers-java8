package com.marsrovers.control

import com.marsrovers.location.Orientation
import com.marsrovers.location.Position
import org.junit.Test
import com.marsrovers.units.Rover
import org.junit.Assert.assertEquals

class CommandDelegationTest {

    @Test
    @Throws(Exception::class)
    fun fromStringShouldReturnProperCommand() {

        assertEquals(CommandDelegation.LEFT, CommandDelegation.Companion.fromString("L"))
        assertEquals(CommandDelegation.RIGHT, CommandDelegation.Companion.fromString("R"))
        assertEquals(CommandDelegation.MOVE, CommandDelegation.Companion.fromString("M"))

    }

    @Test(expected = IllegalArgumentException::class)
    @Throws(Exception::class)
    fun shouldThrowExceptionWhenCommandIsNotFound() {
        CommandDelegation.Companion.fromString("Whatever")
    }

    @Test
    @Throws(Exception::class)
    fun delegateShouldMoveRoverRight() {
        val rover = Rover("a", Orientation.NORTH, Position(1, 1))
        val movedRover = CommandDelegation.RIGHT.delegate(rover)

        assertEquals(Orientation.EAST, movedRover.orientation)
    }

    @Test
    @Throws(Exception::class)
    fun delegateShouldMoveRoverLeft() {
        val rover = Rover("a", Orientation.NORTH, Position(1, 1))
        val movedRover = CommandDelegation.LEFT.delegate(rover)

        assertEquals(Orientation.WEST, movedRover.orientation)
    }

    @Test
    @Throws(Exception::class)
    fun delegateShouldMoveRoverForward() {
        val rover = Rover("a", Orientation.NORTH, Position(1, 1))
        val movedRover = CommandDelegation.MOVE.delegate(rover)

        assertEquals(2, movedRover.position.y.toLong())
    }
}