package com.marsrovers.location;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    public void shouldMoveOnePointRight() throws Exception {

        Position position = new Position(2,2);

        Position movedPosition = position.moveX(+1);

        assertEquals(3, movedPosition.getX());

    }

    @Test
    public void shouldMoveOnePointLeft() throws Exception {

        Position position = new Position(2,2);

        Position movedPosition = position.moveX(-1);

        assertEquals(1, movedPosition.getX());

    }

    @Test
    public void shouldMoveOnePointUp() throws Exception {

        Position position = new Position(2,2);

        Position movedPosition = position.moveY(+1);

        assertEquals(3, movedPosition.getY());

    }

    @Test
    public void shouldMoveOnePointDown() throws Exception {

        Position position = new Position(2,2);

        Position movedPosition = position.moveY(-1);

        assertEquals(1, movedPosition.getY());

    }
}
