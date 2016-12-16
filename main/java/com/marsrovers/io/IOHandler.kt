package com.marsrovers.io


import java.util.Scanner

open class IOHandler internal constructor(private val scanner: Scanner, private val output: (a: String) -> Unit) {

    fun readWithMessage(readingMessage: String): String {
        output(readingMessage)
        return scanner.nextLine()
    }

    fun write(message: String) = output(message)

}
