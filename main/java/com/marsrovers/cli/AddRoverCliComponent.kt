package com.marsrovers.cli


import com.marsrovers.control.MissionController
import com.marsrovers.exceptions.RoverManipulationException
import com.marsrovers.io.IOHandler
import com.marsrovers.location.Orientation
import com.marsrovers.location.Position
import com.marsrovers.units.Rover

class AddRoverCliComponent internal constructor(private val handler: IOHandler, private val controller: MissionController) : CliComponent {

    private fun createRover(roverId: String, xString: String, yString: String, orientationString: String): Rover {

        if (roverId.isEmpty()) {
            throw IllegalArgumentException("roverId can not be empty")
        }

        val x = Integer.parseInt(xString)
        val y = Integer.parseInt(yString)
        val orientation = Orientation.fromString(orientationString)

        return Rover(roverId, orientation, Position(x, y))
    }


    override fun execute() {

        val roverId = handler.readWithMessage("rover_ID>")
        val positionX = handler.readWithMessage("rover_X>")
        val positionY = handler.readWithMessage("rover_Y>")
        val orientationString = handler.readWithMessage("rover_Orientation>")

        try {
            controller.add(createRover(roverId, positionX, positionY, orientationString))
        } catch (ex: NumberFormatException) {
            handler.write("An invalid number was received, the error is: " + ex.message)
        } catch (ex: IllegalArgumentException) {
            handler.write(ex.message!!)
        } catch (ex: RoverManipulationException) {
            handler.write(ex.message!!)
        }

    }

}
