package com.marsrovers.cli;


import com.marsrovers.control.MissionController;
import com.marsrovers.io.IOHandler;

public class MainMenu {

    private static final String MENU_CHOICES = "0 - Exit\n1 - Execute a remote command\n2 - Add a new rover to the field";

    private final IOHandler handler;
    private final MissionController controller;

    public MainMenu(IOHandler handler, MissionController controller) {
        this.handler = handler;
        this.controller = controller;
    }

    public CliComponent getSelectedCliComponent() {

        String choice = handler.readWithMessage(MENU_CHOICES);

        if (choice.equals("0")) {
            System.exit(0);
        }

        if (choice.equals("1")) {
            return new SendCommandCliComponent(handler, controller);
        }

        if (choice.equals("2")) {
            return new AddRoverCliComponent(handler, controller);
        }

        throw new IllegalArgumentException("Invalid menu choice");

    }

}
