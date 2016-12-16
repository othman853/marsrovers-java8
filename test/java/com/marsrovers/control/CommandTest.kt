package com.marsrovers.control

import org.junit.Test

import java.util.Arrays.asList
import java.util.Collections.emptyList

import java.util.Arrays

import org.junit.Assert.*


class CommandTest {


    @Test
    @Throws(Exception::class)
    fun commandShouldBeParseable() {

        val command1 = Command("LMR")
        val command2 = Command("LMRL")
        val command3 = Command("LLMRL")
        val command4 = Command("LLMRLM")

        assertEquals(asList("L", "M", "R"), command1.moveList)
        assertEquals(asList("L", "M", "R", "L"), command2.moveList)
        assertEquals(asList("L", "L", "M", "R", "L"), command3.moveList)
        assertEquals(asList("L", "L", "M", "R", "L", "M"), command4.moveList)
    }

    @Test
    @Throws(Exception::class)
    fun commandShouldNotBeParseableBecauseItsInvalid() {

        val command = Command("ABC")

        val moveList = command.moveList

        assertEquals(emptyList<Any>(), moveList)
    }

    @Test
    @Throws(Exception::class)
    fun commandShouldNotBeParseableBecauseItsEmpty() {

        val command = Command("")

        assertEquals(emptyList<Any>(), command.moveList)
    }


    @Test
    @Throws(Exception::class)
    fun commandShouldReturnAValidMoveList() {
        val command = Command("LMR")

        assertEquals(3, command.moveList.size.toLong())
        assertEquals("L", command.moveList[0])
        assertEquals("M", command.moveList[1])
        assertEquals("R", command.moveList[2])

    }

    @Test
    @Throws(Exception::class)
    fun commandShouldReturnAnEmptyMoveList() {
        val command = Command("")

        assertEquals(0, command.moveList.size.toLong())
    }
}