package location;


import control.Command;
import control.CommandExecutor;
import units.Rover;

import java.util.HashMap;
import java.util.Map;

public class MissionController {

    private final Plateau plateau;
    private final CommandExecutor executor;
    private final Map<String, Rover> rovers = new HashMap<>();

    public MissionController(Plateau plateau, CommandExecutor executor) {
        this.plateau = plateau;
        this.executor = executor;
    }

    public void add(Rover rover) {
        plateau.add(rover);
    }

    public void send(String roverId, Command command) {
        Rover rover = plateau.get(roverId);
        Rover movedRover = executor.execute(rover, command);

        if (!plateau.isOccupied(movedRover.position)) {
            plateau.set(movedRover);
        }
    }

}
