package cli;


import control.MissionController;
import io.IOHandler;
import location.Orientation;
import location.Position;
import units.Rover;

public class AddRoverCliComponent implements CliComponent {


    private final IOHandler handler;
    private final MissionController controller;

    AddRoverCliComponent(IOHandler handler, MissionController controller) {
        this.handler = handler;
        this.controller = controller;
    }

    public void execute() {

        String roverInput = handler.readWithMessage("Type [rover_id,x,y,orientation] or C to cancel: ");

        if (!roverInput.equals("C")) {
            String [] roverInfo = roverInput.split(",");
            controller.add(new Rover(roverInfo[0], Orientation.fromString(roverInfo[3]), new Position(Integer.parseInt(roverInfo[1]), Integer.parseInt(roverInfo[2]))));
        }
    }

}
