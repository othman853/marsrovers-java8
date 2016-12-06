import control.Command;
import control.CommandExecutor;
import location.*;
import units.Rover;

public class MarsRovers {

    public static void main(String[] args) {

        PlateauFactory factory = new PlateauFactory();
        Plateau plateau = factory.createDefaultPlateau();

        CommandExecutor executor = new CommandExecutor();

        MissionController controller = new MissionController(plateau, executor);

        Rover rover = new Rover("a1", Orientation.NORTH, new Position(1,2));


        controller.add(rover);

        Command command = new Command("MMMMMMMMMMMR");
        Command command2 = new Command("MM");

        controller.send("a1", command);
        controller.send("a1", command2);

        System.out.println(plateau.toString());

    }

}
