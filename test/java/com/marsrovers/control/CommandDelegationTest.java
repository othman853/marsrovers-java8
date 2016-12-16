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

        assertEquals(LEFT, Companion.fromString("L"));
        assertEquals(RIGHT, Companion.fromString("R"));
        assertEquals(MOVE, Companion.fromString("M"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenCommandIsNotFound() throws Exception {
        Companion.fromString("Whatever");
    }

    @Test
    public void delegateShouldMoveRoverRight() throws Exception {
        Rover rover = new Rover("a", Orientation.NORTH, new Position(1,1));
        Rover movedRover = RIGHT.delegate(rover);

        assertEquals(Orientation.EAST, movedRover.getOrientation());
    }

    @Test
    public void delegateShouldMoveRoverLeft() throws Exception {
        Rover rover = new Rover("a", Orientation.NORTH, new Position(1,1));
        Rover movedRover = LEFT.delegate(rover);

        assertEquals(Orientation.WEST, movedRover.getOrientation());
    }

    @Test
    public void delegateShouldMoveRoverForward() throws Exception {
        Rover rover = new Rover("a", Orientation.NORTH, new Position(1,1));
        Rover movedRover = MOVE.delegate(rover);

        assertEquals(2, movedRover.getPosition().getY());
    }
}