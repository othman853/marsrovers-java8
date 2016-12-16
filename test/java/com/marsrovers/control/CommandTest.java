package com.marsrovers.control;

import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class CommandTest {


    @Test
    public void commandShouldBeParseable() throws Exception {

        Command command1 = new Command("LMR");
        Command command2 = new Command("LMRL");
        Command command3 = new Command("LLMRL");
        Command command4 = new Command("LLMRLM");

        assertEquals(asList("L", "M", "R"), command1.getMoveList());
        assertEquals(asList("L", "M", "R", "L"), command2.getMoveList());
        assertEquals(asList("L", "L", "M", "R", "L"), command3.getMoveList());
        assertEquals(asList("L", "L", "M", "R", "L", "M"), command4.getMoveList());
    }

    @Test
    public void commandShouldNotBeParseableBecauseItsInvalid() throws Exception {

        Command command = new Command("ABC");

        List<String> moveList = command.getMoveList();

        assertEquals(emptyList(), moveList);
    }

    @Test
    public void commandShouldNotBeParseableBecauseItsEmpty() throws Exception {

        Command command = new Command("");

        assertEquals(emptyList(), command.getMoveList());
    }

    @Test
    public void commandShouldNotBeParseableBecauseItsNull() throws Exception {

        Command command = new Command(null);

        assertEquals(emptyList(), command.getMoveList());
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