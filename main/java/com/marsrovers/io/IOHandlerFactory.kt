package com.marsrovers.io


import java.util.Scanner

class IOHandlerFactory {

    fun createDefaultIOHandler(): IOHandler {
        return IOHandler(Scanner(System.`in`), Output { println(it) })
    }

}
