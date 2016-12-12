package com.marsrovers.control;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public class Command {

    private static final String VALID_COMMAND_REGEX = "[LMR]+";
    private static final String MOVE_COMMAND_REGEX= "[M]+";
    private static final String EMPTY_REGEX = "";

    private final String commandString;

    public Command(String commandString) {
        this.commandString = commandString;
    }

    private boolean isExecutable() {
        return commandString != null && commandString.matches(VALID_COMMAND_REGEX);
    }

    boolean containsMove() {
        return commandString != null && commandString.matches(MOVE_COMMAND_REGEX);
    }

    List<String> getMoveList() {
        return isExecutable()
                ? asList(commandString.split(EMPTY_REGEX))
                : emptyList();
    }

}
