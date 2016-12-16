package com.marsrovers

import com.marsrovers.cli.MainMenu
import com.marsrovers.control.CommandExecutor
import com.marsrovers.control.MissionController
import com.marsrovers.io.IOHandlerFactory
import com.marsrovers.location.PlateauFactory


object Main {

    @JvmStatic fun main(args: Array<String>) {

        var handler = IOHandlerFactory().createDefaultIOHandler()
        var controller = MissionController(PlateauFactory().createDefaultPlateau(), CommandExecutor())

        val rovers = MarsRovers(handler, controller, menu = MainMenu(handler, controller))

        while (true) {
            rovers.menu()
        }
    }
}
