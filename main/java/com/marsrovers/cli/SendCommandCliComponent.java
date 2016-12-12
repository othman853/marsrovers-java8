package com.marsrovers.cli;


import com.marsrovers.control.Command;
import com.marsrovers.control.MissionController;
import com.marsrovers.exceptions.RoverNotFoundException;
import com.marsrovers.io.IOHandler;

public class SendCommandCliComponent implements CliComponent{

    private final IOHandler handler;
    private final MissionController controller;

    SendCommandCliComponent(IOHandler handler, MissionController controller) {
        this.handler = handler;
        this.controller = controller;
    }


    @Override
    public void execute() {

        try {
            handler.write("Invalid commands will be ignored.");
            String roverId = handler.readWithMessage("rover_id>");
            String commandString= handler.readWithMessage("command>");

            handler.write(commandString);

            controller.send(roverId, new Command(commandString));

        } catch (RoverNotFoundException e) {
            handler.write(e.getMessage());
        }
    }
}
