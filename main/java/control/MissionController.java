package control;


import location.Plateau;
import units.Rover;

import java.util.Optional;

public class MissionController {

    private final Plateau plateau;
    private final CommandExecutor executor;

    public MissionController(Plateau plateau, CommandExecutor executor) {
        this.plateau = plateau;
        this.executor = executor;
    }

    public void add(Rover rover) {
        plateau.set(rover);
    }

    public void send(String roverId, Command command) {
        Optional<Rover> rover = plateau.get(roverId);

        if (rover.isPresent()) {

            Rover movedRover = executor.execute(rover.get(), command);

            if (!plateau.isOccupied(movedRover.position)) {
                plateau.set(movedRover);
            }
        }
    }

}
