package com.marsrovers.cli


import com.marsrovers.control.MissionController
import com.marsrovers.io.IOHandler

class MainMenu(private val handler: IOHandler, private val controller: MissionController) {

    val selectedCliComponent: CliComponent
        get() {

            val choice = handler.readWithMessage(MENU_CHOICES)

            if (choice == "0") {
                System.exit(0)
            }

            if (choice == "1") {
                return SendCommandCliComponent(handler, controller)
            }

            if (choice == "2") {
                return AddRoverCliComponent(handler, controller)
            }

            throw IllegalArgumentException("Invalid menu choice")

        }

    companion object {

        private val MENU_CHOICES = "0 - Exit\n1 - Execute a remote command\n2 - Add a new rover to the field"
    }

}
