package com.marsrovers.units;

import com.marsrovers.location.Position;
import org.junit.Test;

import static com.marsrovers.location.Orientation.*;
import static org.junit.Assert.assertEquals;

public class RoverTest {

    private final String roverId = "a";
    private final Rover rover = new Rover(roverId, NORTH, new Position(1,1));


    @Test
    public void roverShouldMoveOrientationLeft() throws Exception {

        Rover newRover = rover.left();

        assertEquals(WEST, newRover.orientation);

    }

    @Test
    public void locationShouldMoveOrientationRight() throws Exception {

        Rover newRover = rover.right();

        assertEquals(EAST, newRover.orientation);

    }

    @Test
    public void locationShouldMovePositionUp() throws Exception {

        Rover newRover = rover.move();

        assertEquals(2, newRover.position.getY());

    }

    @Test
    public void locationShouldMovePositionDown() throws Exception {

        Rover rover = new Rover(roverId, SOUTH, new Position(1,1));

        Rover newRover = rover.move();

        assertEquals(0, newRover.position.getY());

    }

    @Test
    public void toStringShouldBeCorrect() throws Exception {
        String asString = rover.toString();

        assertEquals("a " + rover.position.toString() + " " + rover.orientation.toString(), asString);

    }
}