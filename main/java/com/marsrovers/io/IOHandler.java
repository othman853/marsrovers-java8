package com.marsrovers.io;


import java.util.Scanner;

public class IOHandler {

    private final Scanner scanner;
    private final Output output;

    IOHandler(Scanner scanner, Output output) {
        this.scanner = scanner;
        this.output = output;
    }

    public String readWithMessage(String readingMessage) {
        output.write(readingMessage);
        return scanner.nextLine();
    }

    public void write(String message) {
        output.write(message);
    }



}
