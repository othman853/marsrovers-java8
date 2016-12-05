package control;


import units.Rover;

import java.util.List;
import java.util.stream.Collectors;

public class CommandExecutor {

    public Rover execute(Rover rover, Command command) {

        if (!command.isExecutable()) {
            return rover;
        }

        Rover delegatedRover = rover;

        List<CommandDelegator> commands = command
                                                .getMoveList()
                                                .stream()
                                                .map(CommandDelegator::fromString)
                                                .collect(Collectors.toList());


        for (CommandDelegator commandDelegator : commands) {
            delegatedRover = commandDelegator.delegate(delegatedRover);
        }

        return delegatedRover;

    }

}
