package com.marsrovers.io;


import java.util.Scanner;

public class IOHandlerFactory {

    public IOHandler createDefaultIOHandler() {
        return new IOHandler(new Scanner(System.in), System.out::println);
    }

}
