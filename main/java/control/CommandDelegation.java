package control;

import units.Rover;

import java.util.Arrays;
import java.util.Optional;

public enum CommandDelegation {

    RIGHT("R") {
        public Rover delegate(Rover rover) {return rover.right();}
    },
    LEFT("L") {
        public Rover delegate(Rover rover) { return rover.left(); }
    },
    MOVE("M") {
        public Rover delegate(Rover rover) { return rover.move();}
    };


    private String command;

    CommandDelegation(String command) {
        this.command = command;
    }

    public static CommandDelegation fromString(String string) {

        Optional<CommandDelegation> delegator = Arrays
                .stream(values())
                .filter(d -> d.command.equals(string))
                .findFirst();

        if (!delegator.isPresent()) {
            throw new IllegalArgumentException("No such command");
        }

        return delegator.get();
    }

    public abstract Rover delegate(Rover rover);

}
