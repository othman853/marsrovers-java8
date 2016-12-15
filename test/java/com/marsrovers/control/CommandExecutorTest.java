package com.marsrovers.control;

import com.marsrovers.location.Orientation;
import com.marsrovers.location.Position;
import org.junit.Test;
import com.marsrovers.units.Rover;

import static org.junit.Assert.assertEquals;


public class CommandExecutorTest {

    private final CommandExecutor executor = new CommandExecutor();
    private final Rover rover = new Rover("a", Orientation.NORTH, new Position(1,1));

    @Test
    public void executeShouldSkipNonExecutableCommand() throws Exception {
        Command command = new Command("I am not executable");

        Rover movedRover = executor.execute(rover, command);

        assertEquals(rover, movedRover);
    }

    @Test
    public void executeShouldTurnRoverLeft() throws Exception {


        Command command = new Command("L");

        Rover movedRover = executor.execute(rover, command);

        assertEquals(Orientation.WEST, movedRover.orientation);

    }

    @Test
    public void executeShouldMoveRover() throws Exception {

        Command command = new Command("M");

        Rover movedRover = executor.execute(rover, command);

        assertEquals(2, movedRover.position.getY());

    }

    @Test
    public void executeShouldTurnRoverRight() throws Exception {

        Command command = new Command("R");

        Rover movedRover = executor.execute(rover, command);

        assertEquals(Orientation.EAST, movedRover.orientation);

    }

    @Test
    public void executeShouldExecuteMultipleMovesCommand() throws Exception {

        Command command = new Command("LLM");

        Rover movedRover = executor.execute(rover, command);

        assertEquals(0, movedRover.position.getY());

    }
}