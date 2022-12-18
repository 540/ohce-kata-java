package com.deg540.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OhceRunnerTest {
    private Ohce ohce;
    private ConsoleManager ohceScanner;
    private OhceRunner ohceRunner;

    @BeforeEach
    void setUp() {
        ohceScanner = mock(ConsoleManager.class);
        ohce = mock(Ohce.class);
        ohceRunner = new OhceRunner(ohceScanner, ohce);
    }

    @Test
    void ohceIsNotStarted() {
        when(ohceScanner.read()).thenReturn("hey Pedro");

        ohceRunner.run();

        verify(ohceScanner, times(1)).read();
        verify(ohce, times(0)).run(any());
    }

    @Test
    void ohceIsStarted() {
        String scannerRead = "Ohce Pedro";
        String ocheResponse = "Buenos días Pedro";

        when(ohceScanner.read()).thenReturn(scannerRead);
        when(ohce.run(scannerRead)).thenReturn(ocheResponse);

        ohceRunner.run();

        verify(ohceScanner, times(1)).read();
        verify(ohce, times(1)).run(scannerRead);
        verify(ohceScanner, times(1)).write(ocheResponse);
    }

    @Test
    void ohceIsCalledAfterStarted() {
        String scannerStartRead = "Ohce Pedro";
        String scannerStartedRead = "hola";
        String ocheStartResponse = "Buenos días Pedro";
        String ocheStartedResponse = "aloh";

        when(ohceScanner.read()).thenReturn(scannerStartRead, scannerStartedRead);
        when(ohce.run(scannerStartRead)).thenReturn(ocheStartResponse);
        when(ohce.run(scannerStartedRead)).thenReturn(ocheStartedResponse);

        ohceRunner.run();
        ohceRunner.run();

        verify(ohce, times(1)).run(scannerStartRead);
        verify(ohce, times(1)).run(scannerStartedRead);
        verify(ohceScanner, times(1)).write(ocheStartResponse);
        verify(ohceScanner, times(1)).write(ocheStartedResponse);
    }

    @Test
    void ohceIsStopped() {
        String scannerStartRead = "Ohce Pedro";
        String scannerStopRead = "Stop!";
        String ocheStartResponse = "Buenos días Pedro";
        String ocheStopResponse = "Adios Pedro";

        when(ohceScanner.read()).thenReturn(scannerStartRead, scannerStopRead);
        when(ohce.run(scannerStartRead)).thenReturn(ocheStartResponse);
        when(ohce.run(scannerStopRead)).thenReturn(ocheStopResponse);

        ohceRunner.run();
        ohceRunner.run();
        ohceRunner.run();

        verify(ohce, times(1)).run(scannerStartRead);
        verify(ohce, times(1)).run(scannerStopRead);
        verify(ohce, times(0)).run(ocheStopResponse);
        verify(ohceScanner, times(1)).write(ocheStartResponse);
        verify(ohceScanner, times(1)).write(ocheStopResponse);
    }
}
