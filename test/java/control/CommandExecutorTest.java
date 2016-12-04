package control;

import location.Orientation;
import location.Position;
import org.junit.Test;
import units.Rover;

import static org.junit.Assert.*;


public class CommandExecutorTest {

    @Test
    public void executeShouldTurnRoverLeft() throws Exception {

        Rover rover = new Rover("a", Orientation.NORTH, new Position(1,1));
        CommandExecutor executor = new CommandExecutor();
        Command command = new Command("L");

        Rover movedRover = executor.execute(rover, command);

        assertEquals(Orientation.WEST, movedRover.orientation);

    }

    @Test
    public void executeShouldMoveRover() throws Exception {

        Rover rover = new Rover("a", Orientation.NORTH, new Position(1,1));
        CommandExecutor executor = new CommandExecutor();
        Command command = new Command("M");

        Rover movedRover = executor.execute(rover, command);

        assertEquals(2, movedRover.position.y);

    }

    @Test
    public void executeShouldTurnRoverRight() throws Exception {

        Rover rover = new Rover("a", Orientation.NORTH, new Position(1,1));
        CommandExecutor executor = new CommandExecutor();
        Command command = new Command("R");

        Rover movedRover = executor.execute(rover, command);

        assertEquals(Orientation.EAST, movedRover.orientation);

    }

    @Test
    public void executeShouldExecuteMultipleMovesCommand() throws Exception {

        Rover rover = new Rover("a", Orientation.NORTH, new Position(1,1));
        CommandExecutor executor = new CommandExecutor();
        Command command = new Command("LLM");

        Rover movedRover = executor.execute(rover, command);

        assertEquals(0, movedRover.position.y);

    }
}