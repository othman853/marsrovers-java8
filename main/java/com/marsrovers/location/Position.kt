package com.marsrovers.location

class Position(val x: Int, val y: Int) {

    fun moveX(amount: Int) = Position(x + amount, y)
    fun moveY(amount: Int) = Position(x, y + amount)

    override fun toString() = "$x, $y"

    override fun equals(o: Any?): Boolean {
        val that = o as Position?
        return that!!.x == x && that.y == y
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}
