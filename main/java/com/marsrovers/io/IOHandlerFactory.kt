package com.marsrovers.io


import java.util.Scanner

class IOHandlerFactory {
    fun createDefaultIOHandler(): IOHandler = IOHandler(Scanner(System.`in`), ::println)
}
