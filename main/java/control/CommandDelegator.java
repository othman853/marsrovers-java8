package control;

import units.Rover;

import java.util.Arrays;
import java.util.Optional;

public enum CommandDelegator {

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

    CommandDelegator(String command) {
        this.command = command;
    }

    public static CommandDelegator fromString(String string) {

        Optional<CommandDelegator> delegator = Arrays
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
