package com.marsrovers.cli


import com.marsrovers.control.Command
import com.marsrovers.control.MissionController
import com.marsrovers.exceptions.RoverNotFoundException
import com.marsrovers.io.IOHandler

class SendCommandCliComponent internal constructor(private val handler: IOHandler, private val controller: MissionController) : CliComponent {


    override fun execute() {

        try {
            handler.write("Invalid commands will be ignored.")
            val roverId = handler.readWithMessage("rover_id>")
            val commandString = handler.readWithMessage("command>")

            handler.write(commandString)

            controller.send(roverId, Command(commandString))

        } catch (e: RoverNotFoundException) {
            handler.write(e.message!!)
        }

    }
}
