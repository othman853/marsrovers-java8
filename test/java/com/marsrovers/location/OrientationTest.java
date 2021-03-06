package com.marsrovers.location;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static com.marsrovers.location.Orientation.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OrientationTest {

    @Test
    public void northShouldHaveProperRightAndLeftOrientations() throws Exception {
        assertEquals(WEST, NORTH.left());
        assertEquals(EAST, NORTH.right());
    }

    @Test
    public void northShouldHaveProperStringRepresentation() throws Exception {
        assertEquals("N", NORTH.toString());
    }

    @Test
    public void northShouldBeVertical() throws Exception {
        assertTrue(NORTH.isVertical());
    }

    @Test
    public void northShouldMoveUp() throws Exception {
        assertEquals(1, NORTH.getMove());
    }

    @Test
    public void eastShouldHaveProperRightAndLeftOrientations() throws Exception {
        assertEquals(NORTH, EAST.left());
        assertEquals(SOUTH, EAST.right());
    }

    @Test
    public void eastShouldBeHorizontal() throws Exception {
        assertFalse(EAST.isVertical());
    }

    @Test
    public void eastShouldMoveRight() throws Exception {
        assertEquals(1, EAST.getMove());
    }

    @Test
    public void eastShouldHaveProperStringRepresentation() throws Exception {
        assertEquals("E", EAST.toString());
    }

    @Test
    public void southShouldHaveProperRightAndLeftOrientations() throws Exception {
        assertEquals(WEST, SOUTH.left());
        assertEquals(EAST, SOUTH.right());
    }

    @Test
    public void southShouldBeVertical() throws Exception {
        assertTrue(SOUTH.isVertical());
    }

    @Test
    public void southShouldGoDown() throws Exception {
        assertEquals(-1, SOUTH.getMove());
    }

    @Test
    public void southShouldHaveProperStringRepresentation() throws Exception {
        assertEquals("S", SOUTH.toString());
    }

    @Test
    public void westShouldHaveProperRightAndLeftOrientations() throws Exception {
        assertEquals(SOUTH, WEST.left());
        assertEquals(NORTH, WEST.right());
    }

    @Test
    public void westShouldBeHorizontal() throws Exception {
        assertFalse(WEST.isVertical());
    }

    @Test
    public void westShouldMoveLeft() throws Exception {
        assertEquals(-1, WEST.getMove());
    }

    @Test
    public void westShouldHaveProperStringRepresentation() throws Exception {
        assertEquals("W", WEST.toString());
    }

    @Test
    public void fromStringShouldReturnCorrectValues() throws Exception {

        assertEquals(NORTH, Companion.fromString("N"));
        assertEquals(EAST, Companion.fromString("E"));
        assertEquals(WEST, Companion.fromString("W"));
        assertEquals(SOUTH, Companion.fromString("S"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void fromStringShouldThrowExceptionIfValueIsInvalid() throws Exception {
        Companion.fromString("A");
    }
}
