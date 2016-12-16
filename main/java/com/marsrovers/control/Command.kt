package com.marsrovers.control

import java.util.Arrays.asList
import java.util.Collections.emptyList

class Command(private val commandString: String) {

    private fun isExecutable(): Boolean = commandString.matches(VALID_COMMAND_REGEX.toRegex())

    fun containsMove(): Boolean = commandString.matches(MOVE_COMMAND_REGEX.toRegex())

    internal val moveList: List<String>
        get() = if (isExecutable())
            asList(*commandString.split(EMPTY_REGEX.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
        else
            emptyList<String>()

    companion object {

        private val VALID_COMMAND_REGEX = "[LMR]+"
        private val MOVE_COMMAND_REGEX = "[M]+"
        private val EMPTY_REGEX = ""
    }

}
