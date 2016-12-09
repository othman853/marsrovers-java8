package cli;


import control.Command;
import control.MissionController;
import exceptions.RoverNotFoundException;
import io.IOHandler;

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

            String input = handler.readWithMessage("[rover_id,command]");

            String roverId = input.split(",")[0];
            String command  = input.split(",")[1];

            controller.send(roverId, new Command(command));

        } catch (RoverNotFoundException e) {
            handler.write(e.getMessage());
        }
    }
}
