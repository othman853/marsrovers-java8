package com.marsrovers.control


import com.marsrovers.exceptions.RoverManipulationException
import com.marsrovers.exceptions.RoverNotFoundException
import com.marsrovers.location.Plateau
import com.marsrovers.units.Rover

import java.util.Optional

class MissionController(private val plateau: Plateau, private val executor: CommandExecutor) {

    @Throws(RoverManipulationException::class)
    fun add(rover: Rover) {

        if (plateau.isOccupied(rover)) {
            throw RoverManipulationException("There is already a rover ocuppying the position: " + rover.position.toString())
        }

        plateau.set(rover)

    }

    @Throws(RoverNotFoundException::class)
    fun send(roverId: String, command: Command) {
        val rover = plateau[roverId]

        if (!rover.isPresent) {
            throw RoverNotFoundException("No rover available with id: " + roverId)
        }

        val movedRover = executor.execute(rover.get(), command)

        if (!command.containsMove() || !plateau.isOccupied(movedRover)) {
            plateau.set(movedRover)
        }

    }

    val status: String
        get() = plateau.toString()

}
