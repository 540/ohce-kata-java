package com.deg540.tdd;

public class OhceRunner {

    private final ConsoleManager ohceScanner;
    private final Ohce ohce;
    private boolean ocheIsStarted = false;

    public OhceRunner(ConsoleManager ohceScanner, Ohce ohce) {
        this.ohceScanner = ohceScanner;
        this.ohce = ohce;
    }

    public void run() {
        String scannerRead = ohceScanner.read();
        if (scannerRead.contains("Ohce") || ocheIsStarted) {
            ocheIsStarted = true;
            String ohceResponse = ohce.run(scannerRead);
            ohceScanner.write(ohceResponse);
            if (scannerRead.equals(Ohce.STOP_WORD)) {
                ocheIsStarted = false;
            }
        }
    }
}
