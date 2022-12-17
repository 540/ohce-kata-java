package com.deg540.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OhceTest {
    private TimeProvider timeProvider;
    private Ohce ohce;

    @BeforeEach
    void setUp() {
        timeProvider = mock(TimeProvider.class);
        ohce = new Ohce(timeProvider);
    }

    @Test
    void reversesNotPalindrome() {
        String reversedWord = ohce.run("Hola");

        assertEquals("aloH", reversedWord);
    }

    @Test
    void reversesPalindromeAndAppreciatesIt() {
        String echoedWord = ohce.run("oto");

        assertEquals("oto " + Ohce.PALINDROME_GREETING , echoedWord);
    }

    @Test
    void greetsInTheMorning() {
        when(timeProvider.getCurrentHour()).thenReturn(10);

        String ocheOutput = ohce.run("Ohce Pedro");

        assertEquals(Ohce.MORNING_GREETING+" Pedro", ocheOutput);
    }

    @Test
    void greetsInTheAfternoon() {
        when(timeProvider.getCurrentHour()).thenReturn(16);

        String ocheOutput = ohce.run("Ohce Pedro");

        assertEquals(Ohce.AFTERNOON_GREETING+" Pedro", ocheOutput);
    }

    @Test
    void greetsAtNight() {
        when(timeProvider.getCurrentHour()).thenReturn(23);

        String ocheOutput = ohce.run("Ohce Pedro");

        assertEquals(Ohce.NIGHT_GREETING+" Pedro", ocheOutput);
    }

    @Test
    void stopsOhce() {
        ohce.run("Ohce Pedro");

        String ocheOutput = ohce.run("Stop!");

        assertEquals("Adiós Pedro", ocheOutput);
    }
}
