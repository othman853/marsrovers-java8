package com.marsrovers.control;


import com.marsrovers.exceptions.RoverManipulationException;
import com.marsrovers.exceptions.RoverNotFoundException;
import com.marsrovers.location.Plateau;
import com.marsrovers.units.Rover;

import java.util.Optional;

public class MissionController {

    private final Plateau plateau;
    private final CommandExecutor executor;

    public MissionController(Plateau plateau, CommandExecutor executor) {
        this.plateau = plateau;
        this.executor = executor;
    }

    public void add(Rover rover) throws RoverManipulationException {

        if (plateau.isOccupied(rover)) {
            throw new RoverManipulationException("There is already a rover ocuppying the position: " + rover.position.toString());
        }

        plateau.set(rover);

    }

    public void send(String roverId, Command command) throws RoverNotFoundException {
        Optional<Rover> rover = plateau.get(roverId);

        if (!rover.isPresent()) {
            throw new RoverNotFoundException("No rover available with id: " + roverId);
        }

        Rover movedRover = executor.execute(rover.get(), command);

        if ( (command.containsMove() && !plateau.isOccupied(movedRover)) || !command.containsMove()) {
            plateau.set(movedRover);
        }

    }

    public String getStatus() {
        return plateau.toString();
    }

}
