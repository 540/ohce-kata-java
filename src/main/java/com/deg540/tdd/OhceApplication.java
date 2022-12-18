package com.deg540.tdd;

public class OhceApplication {
    public static void main(String[] args) {
        OhceRunner ohceRunner = new OhceRunner(new ConsoleManager(), new Ohce(new TimeProvider()));
        while (true){
            ohceRunner.run();
        }
    }
}
