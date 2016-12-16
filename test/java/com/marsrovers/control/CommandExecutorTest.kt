package com.marsrovers.control

import com.marsrovers.location.Orientation
import com.marsrovers.location.Position
import org.junit.Test
import com.marsrovers.units.Rover

import org.junit.Assert.assertEquals


class CommandExecutorTest {

    private val executor = CommandExecutor()
    private val rover = Rover("a", Orientation.NORTH, Position(1, 1))

    @Test
    @Throws(Exception::class)
    fun executeShouldSkipNonExecutableCommand() {
        val command = Command("I am not executable")

        val movedRover = executor.execute(rover, command)

        assertEquals(rover, movedRover)
    }

    @Test
    @Throws(Exception::class)
    fun executeShouldTurnRoverLeft() {


        val command = Command("L")

        val movedRover = executor.execute(rover, command)

        assertEquals(Orientation.WEST, movedRover.orientation)

    }

    @Test
    @Throws(Exception::class)
    fun executeShouldMoveRover() {

        val command = Command("M")

        val movedRover = executor.execute(rover, command)

        assertEquals(2, movedRover.position.y.toLong())

    }

    @Test
    @Throws(Exception::class)
    fun executeShouldTurnRoverRight() {

        val command = Command("R")

        val movedRover = executor.execute(rover, command)

        assertEquals(Orientation.EAST, movedRover.orientation)

    }

    @Test
    @Throws(Exception::class)
    fun executeShouldExecuteMultipleMovesCommand() {

        val command = Command("LLM")

        val movedRover = executor.execute(rover, command)

        assertEquals(0, movedRover.position.y.toLong())

    }
}