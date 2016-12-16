package com.marsrovers

import com.marsrovers.cli.MainMenu
import com.marsrovers.control.MissionController
import com.marsrovers.io.IOHandler

internal class MarsRovers(private val handler: IOHandler, private val controller: MissionController, private val menu: MainMenu) {

    fun menu() {
        handler.write(controller.status)

        val component = menu.selectedCliComponent

        component.execute()
    }

}
