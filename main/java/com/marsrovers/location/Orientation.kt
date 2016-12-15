package com.marsrovers.location


import java.util.Arrays
import java.util.Optional

enum class Orientation constructor(private val string: String, val isVertical: Boolean, val move: Int) {

    SOUTH("S", true, -1) {
        override fun left() = WEST
        override fun right() = EAST
    },
    WEST("W", false, -1) {
        override fun left() = SOUTH
        override fun right() = NORTH
    },
    NORTH("N", true, +1) {
        override fun left() = WEST
        override fun right() = EAST
    },
    EAST("E", false, +1) {
        override fun left() = NORTH
        override fun right() = SOUTH
    };

    override fun toString(): String = this.string

    abstract fun left(): Orientation
    abstract fun right(): Orientation

    companion object {

        fun fromString(orientation: String): Orientation {

            val orientationOptional = Arrays
                    .stream(values())
                    .filter { o -> o.string == orientation }
                    .findFirst()

            if (!orientationOptional.isPresent) {
                throw IllegalArgumentException("Orientation $orientation does not exists")
            }

            return orientationOptional.get()
        }
    }

}
