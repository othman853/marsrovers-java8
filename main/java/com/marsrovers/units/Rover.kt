package com.marsrovers.units


import com.marsrovers.location.Orientation
import com.marsrovers.location.Position


open class Rover(val id: String, val orientation: Orientation, val position: Position) {


    fun left(): Rover = Rover(id, orientation.left(), position)

    fun right(): Rover = Rover(id, orientation.right(), position)

    fun move(): Rover {

        return if (orientation.isVertical)
            Rover(id, orientation, position.moveY(orientation.move))
        else
            Rover(id, orientation, position.moveX(orientation.move))
    }

    override fun toString(): String = arrayOf(id, position.toString(), orientation.toString()).joinToString(" ")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Rover

        if (id != other.id) return false
        if (orientation != other.orientation) return false
        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + orientation.hashCode()
        result = 31 * result + position.hashCode()
        return result
    }


}
