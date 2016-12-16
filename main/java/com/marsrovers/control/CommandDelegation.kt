package com.marsrovers.control

import com.marsrovers.units.Rover

import java.util.Arrays
import java.util.Optional

enum class CommandDelegation private constructor(private val command: String) {

    RIGHT("R") {
        override fun delegate(rover: Rover): Rover = rover.right()
    },
    LEFT("L") {
        override fun delegate(rover: Rover): Rover = rover.left()
    },
    MOVE("M") {
        override fun delegate(rover: Rover): Rover = rover.move()
    };

    abstract fun delegate(rover: Rover): Rover

    companion object {

        fun fromString(string: String): CommandDelegation {

            val delegation = Arrays
                    .stream(values())
                    .filter { d -> d.command == string }
                    .findFirst()

            if (!delegation.isPresent) {
                throw IllegalArgumentException("No such command " + string)
            }

            return delegation.get()
        }
    }

}
