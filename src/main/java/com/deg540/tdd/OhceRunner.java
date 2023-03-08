package com.deg540.tdd;

public class OhceRunner {

    private final ConsoleManager consoleManager;
    private final Ohce ohce;
    private boolean ocheIsStarted = false;

    public OhceRunner(ConsoleManager consoleManager, Ohce ohce) {
        this.consoleManager = consoleManager;
        this.ohce = ohce;
    }

    public void run() {
        String scannerRead = consoleManager.read();
        if (scannerRead.contains("Ohce") || ocheIsStarted) {
            ocheIsStarted = true;
            String ohceResponse = ohce.run(scannerRead);
            consoleManager.write(ohceResponse);
            if (scannerRead.equals(Ohce.STOP_WORD)) {
                ocheIsStarted = false;
            }
        }
    }
}
