package location;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static location.Orientation.*;

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
    public void eastShouldHaveProperRightAndLeftOrientations() throws Exception {
        assertEquals(NORTH, EAST.left());
        assertEquals(SOUTH, EAST.right());
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
    public void southShouldHaveProperStringRepresentation() throws Exception {
        assertEquals("S", SOUTH.toString());
    }

    @Test
    public void westShouldHaveProperRightAndLeftOrientations() throws Exception {
        assertEquals(SOUTH, WEST.left());
        assertEquals(NORTH, WEST.right());
    }

    @Test
    public void westShouldHaveProperStringRepresentation() throws Exception {
        assertEquals("W", WEST.toString());
    }



}
