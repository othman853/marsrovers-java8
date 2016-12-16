package com.marsrovers.control

import com.marsrovers.exceptions.RoverManipulationException
import com.marsrovers.exceptions.RoverNotFoundException
import com.marsrovers.location.Orientation
import com.marsrovers.location.Plateau
import com.marsrovers.location.Position
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner
import com.marsrovers.units.Rover
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock

import java.util.Optional

import org.mockito.Matchers.any
import org.mockito.Matchers.anyString
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`


@RunWith(MockitoJUnitRunner::class)
class MissionControllerTest {

    @Mock
    private val plateau = mock<Plateau> {}

    @Mock
    private val executor: CommandExecutor? = null

    @Mock
    private val rover: Rover? = null

    @Mock
    private val movedRover: Rover? = null

    private var controller: MissionController? = null
    private var command: Command? = null


    @Before
    @Throws(Exception::class)
    fun setUp() {

        controller = MissionController(plateau!!, executor!!)
        command = Command("a")
    }

    @Test
    @Throws(Exception::class, RoverManipulationException::class)
    fun addShouldCallPlateauAdd() {

        controller!!.add(rover!!)

        verify(plateau).set(rover)
    }

    @Test(expected = RoverManipulationException::class)
    @Throws(Exception::class, RoverManipulationException::class)
    fun addShouldThrowExceptionWhenPositionIsOccupied() {
        val fakeRover = Rover("a", Orientation.NORTH, Position(1, 1))
        `when`(plateau!!.isOccupied(fakeRover)).thenReturn(true)

        controller!!.add(fakeRover)
    }

    @Test
    @Throws(RoverNotFoundException::class)
    fun sendShouldCallPlateauGet() {
        `when`(plateau!![anyString()]).thenReturn(Optional.ofNullable<Rover>(rover))
        `when`(plateau.isOccupied(any(Rover::class.java))).thenReturn(true)
        `when`(executor!!.execute(any(Rover::class.java), any(Command::class.java))).thenReturn(movedRover)

        controller!!.send("abc", Command("a"))

        verify(plateau)["abc"]

    }

    @Test
    @Throws(RoverNotFoundException::class)
    fun sendShouldCallExecutor() {
        `when`(plateau!![anyString()]).thenReturn(Optional.ofNullable<Rover>(rover))
        `when`(plateau.isOccupied(any(Rover::class.java))).thenReturn(true)
        `when`(executor!!.execute(any(Rover::class.java), any(Command::class.java))).thenReturn(movedRover)

        controller!!.send("abc", command!!)

        verify(executor).execute(rover!!, command!!)

    }

    @Test
    @Throws(RoverNotFoundException::class)
    fun sendShouldMoveRover() {

        `when`(plateau!![anyString()]).thenReturn(Optional.ofNullable<Rover>(rover))
        `when`(plateau.isOccupied(any(Rover::class.java))).thenReturn(false)
        `when`(executor!!.execute(any(Rover::class.java), any(Command::class.java))).thenReturn(movedRover)

        controller!!.send("abc", command!!)

        verify(plateau).set(movedRover!!)

    }

    @Test(expected = RoverNotFoundException::class)
    @Throws(RoverNotFoundException::class)
    fun sendShouldThrowException() {

        `when`(plateau!![anyString()]).thenReturn(Optional.ofNullable<Rover>(null))

        controller!!.send("abc", command!!)

    }
}