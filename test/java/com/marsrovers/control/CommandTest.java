package com.marsrovers.control;

import org.junit.Test;

import static org.junit.Assert.*;


public class CommandTest {


    @Test
    public void commandShouldBeParseable() throws Exception {

        Command command1 = new Command("LMR");
        Command command2 = new Command("LMRL");
        Command command3 = new Command("LLMRL");
        Command command4 = new Command("LLMRLM");

        assertTrue(command1.isExecutable());
        assertTrue(command2.isExecutable());
        assertTrue(command3.isExecutable());
        assertTrue(command4.isExecutable());
    }

    @Test
    public void commandShouldNotBeParseableBecauseItsInvalid() throws Exception {

        Command command = new Command("ABC");

        assertFalse(command.isExecutable());
    }

    @Test
    public void commandShouldNotBeParseableBecauseItsEmpty() throws Exception {

        Command command = new Command("");

        assertFalse(command.isExecutable());
    }

    @Test
    public void commandShouldNotBeParseableBecauseItsNull() throws Exception {

        Command command = new Command(null);

        assertFalse(command.isExecutable());
    }

    @Test
    public void commandShouldReturnAValidMoveList() throws Exception {
        Command command = new Command("LMR");

        assertEquals(3, command.getMoveList().size());
        assertEquals("L", command.getMoveList().get(0));
        assertEquals("M", command.getMoveList().get(1));
        assertEquals("R", command.getMoveList().get(2));

    }

    @Test
    public void commandShouldReturnAnEmptyMoveList() throws Exception {
        Command command = new Command("");

        assertEquals(0, command.getMoveList().size());
    }
}