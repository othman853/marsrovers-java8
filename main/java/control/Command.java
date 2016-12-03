package control;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Command {

    private static final String VALID_COMMAND_REGEX = "[LMR]+";
    private static final String EMPTY_REGEX = "";

    public final String commandString;

    public Command(String commandString) {
        this.commandString = commandString;
    }

    public boolean isExecutable() {
        return commandString != null && commandString.matches(VALID_COMMAND_REGEX);
    }

    public List<String> getMoveList() {
        return isExecutable()
                ? Arrays.asList(commandString.split(EMPTY_REGEX))
                : Collections.emptyList();
    }

}
