package com.marsrovers;

import com.marsrovers.cli.MainMenu;
import com.marsrovers.control.CommandExecutor;
import com.marsrovers.control.MissionController;
import com.marsrovers.io.IOHandler;
import com.marsrovers.io.IOHandlerFactory;
import com.marsrovers.location.PlateauFactory;


public class Main {

    public static void main(String[] args) {
        MissionController controller = new MissionController(new PlateauFactory().createDefaultPlateau(), new CommandExecutor());
        IOHandler io = new IOHandlerFactory().createDefaultIOHandler();
        MainMenu menu = new MainMenu(io, controller);

        MarsRovers rovers = new MarsRovers(io, controller, menu);

        while (true) {
            rovers.menu();
        }
    }
}
