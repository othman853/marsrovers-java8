package com.marsrovers.location

import com.marsrovers.units.Rover

import java.util.HashMap
import java.util.Optional

class Plateau internal constructor(val horizontalBoundary: Int, val verticalBoundary: Int) {
    internal val rovers: MutableMap<String, Rover> = HashMap()

    init {

        if (horizontalBoundary <= 0) {
            throw IllegalArgumentException("Horizontal Boundary must be grater than 0")
        }

        if (verticalBoundary <= 0) {
            throw IllegalArgumentException("Vertical Boundary must be grater than 0")
        }
    }

    fun isOccupied(rover: Rover): Boolean = rovers.entries.any { es -> es.value.position == rover.position }

    fun set(rover: Rover) = rovers.put(rover.id, rover)

    operator fun get(roverId: String): Optional<Rover> = Optional.ofNullable<Rover>(rovers[roverId])

    override fun toString(): String =  rovers.entries.joinToString(prefix = "[", postfix = "]")

}
