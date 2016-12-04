package control;

import org.junit.Test;

import static org.junit.Assert.*;
import static control.CommandDelegator.*;


public class CommandDelegatorTest {

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
}