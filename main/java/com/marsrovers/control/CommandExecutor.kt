package com.marsrovers.control


import com.marsrovers.units.Rover
import java.util.stream.Collectors

class CommandExecutor {

    fun execute(rover: Rover, command: Command): Rover {

        var delegatedRover = rover

        command
                .moveList
                .map { move -> CommandDelegation.fromString(move) }
                .forEach { delegation -> delegatedRover = delegation.delegate(delegatedRover) }

        return delegatedRover

    }

}
