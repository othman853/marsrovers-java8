package com.marsrovers.control;


import com.marsrovers.units.Rover;

import java.util.List;
import java.util.stream.Collectors;

public class CommandExecutor {

    Rover execute(Rover rover, Command command) {

        if (!command.isExecutable()) {
            return rover;
        }

        Rover delegatedRover = rover;

        List<CommandDelegation> delegations = command
                                                .getMoveList()
                                                .stream()
                                                .map(CommandDelegation::fromString)
                                                .collect(Collectors.toList());


        for (CommandDelegation delegation : delegations) {
            delegatedRover = delegation.delegate(delegatedRover);
        }

        return delegatedRover;

    }

}
