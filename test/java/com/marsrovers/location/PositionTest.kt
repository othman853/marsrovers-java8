package com.marsrovers.location


import org.junit.Test

import org.junit.Assert.assertEquals

class PositionTest {

    @Test
    @Throws(Exception::class)
    fun shouldMoveOnePointRight() {

        val position = Position(2, 2)

        val movedPosition = position.moveX(+1)

        assertEquals(3, movedPosition.x.toLong())

    }

    @Test
    @Throws(Exception::class)
    fun shouldMoveOnePointLeft() {

        val position = Position(2, 2)

        val movedPosition = position.moveX(-1)

        assertEquals(1, movedPosition.x.toLong())

    }

    @Test
    @Throws(Exception::class)
    fun shouldMoveOnePointUp() {

        val position = Position(2, 2)

        val movedPosition = position.moveY(+1)

        assertEquals(3, movedPosition.y.toLong())

    }

    @Test
    @Throws(Exception::class)
    fun shouldMoveOnePointDown() {

        val position = Position(2, 2)

        val movedPosition = position.moveY(-1)

        assertEquals(1, movedPosition.y.toLong())

    }
}
