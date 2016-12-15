package com.marsrovers.control;

import com.marsrovers.location.Orientation;
import com.marsrovers.location.Position;
import org.junit.Test;
import com.marsrovers.units.Rover;

import static com.marsrovers.control.CommandDelegation.*;
import static org.junit.Assert.assertEquals;


public class CommandDelegationTest {

    @Test
    public void fromStringShouldReturnProperCommand() throws Exception {

        assertEquals(LEFT, fromString("L"));
        assertEquals(RIGHT, fromString("R"));
        assertEquals(MOVE, fromString("M"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenCommandIsNotFound() throws Exception {
        fromString("Whatever");
    }

    @Test
    public void delegateShouldMoveRoverRight() throws Exception {
        Rover rover = new Rover("a", Orientation.NORTH, new Position(1,1));
        Rover movedRover = RIGHT.delegate(rover);

        assertEquals(Orientation.EAST, movedRover.orientation);
    }

    @Test
    public void delegateShouldMoveRoverLeft() throws Exception {
        Rover rover = new Rover("a", Orientation.NORTH, new Position(1,1));
        Rover movedRover = LEFT.delegate(rover);

        assertEquals(Orientation.WEST, movedRover.orientation);
    }

    @Test
    public void delegateShouldMoveRoverForward() throws Exception {
        Rover rover = new Rover("a", Orientation.NORTH, new Position(1,1));
        Rover movedRover = MOVE.delegate(rover);

        assertEquals(2, movedRover.position.getY());
    }
}