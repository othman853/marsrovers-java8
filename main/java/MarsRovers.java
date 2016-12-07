import control.Command;
import control.CommandExecutor;
import control.MissionController;
import location.*;
import units.Rover;

import java.util.Scanner;

public class MarsRovers {

    public static void main(String[] args) {

        PlateauFactory factory = new PlateauFactory();
        Plateau plateau = factory.createDefaultPlateau();

        CommandExecutor executor = new CommandExecutor();

        MissionController controller = new MissionController(plateau, executor);

        Rover rover = new Rover("a1", Orientation.NORTH, new Position(1,2));


        controller.add(rover);

        System.out.println("Plateau Status: ");
        System.out.println(plateau.toString());

        System.out.println("Type a command to send to the rover");
        Scanner reader = new Scanner(System.in);

        String commandString = reader.nextLine();

        Command command = new Command(commandString);

        controller.send("a1", command);

        System.out.println("Result");

        System.out.println(plateau.toString());

    }

}
