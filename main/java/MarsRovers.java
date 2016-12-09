import com.sun.org.apache.xpath.internal.operations.Or;
import control.Command;
import control.CommandExecutor;
import control.MissionController;
import exceptions.RoverNotFoundException;
import io.IOHandler;
import io.IOHandlerFactory;
import location.Orientation;
import location.PlateauFactory;
import location.Position;
import units.Rover;

public class MarsRovers {

    private static final String EXIT_SIGN = "0";

    public static void main(String[] args) {

        MissionController controller = new MissionController(new PlateauFactory().createDefaultPlateau(), new CommandExecutor());

        Rover rover = new Rover("a1", Orientation.NORTH, new Position(1,2));
        controller.add(rover);

        IOHandler io = new IOHandlerFactory().createDefaultIOHandler();

        while (true) {

            System.out.println(controller.getStatus());

            String input = io.readWithMessage("Type [rover_id,command] or 0 to exit: ");

            if (input.equals(EXIT_SIGN)) {
                break;
            }

            try {

                if (input.equals("A")) {
                    String roverInput = io.readWithMessage("Type [rover_id,x,y,orientation] or c to cancel: ");

                    if (!roverInput.equals("C")) {
                        String [] roverInfo = roverInput.split(",");
                        Orientation orientation = Orientation.fromString(roverInfo[3]);

                        Rover rover1 = new Rover(roverInfo[0], orientation, new Position(Integer.parseInt(roverInfo[1]), Integer.parseInt(roverInfo[2])));
                        controller.add(rover1);
                    }
                } else {
                    String roverId = input.split(",")[0];
                    String command  = input.split(",")[1];

                    controller.send(roverId, new Command(command));
                }

            } catch (RoverNotFoundException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid input format");
            }


        }

    }

}
