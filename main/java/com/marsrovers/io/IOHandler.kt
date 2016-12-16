package com.marsrovers.io


import java.util.Scanner

class IOHandler internal constructor(private val scanner: Scanner, private val output: Output) {

    fun readWithMessage(readingMessage: String): String {
        output.write(readingMessage)
        return scanner.nextLine()
    }

    fun write(message: String) {
        output.write(message)
    }


}
