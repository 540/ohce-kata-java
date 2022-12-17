package com.deg540.tdd;

import java.time.LocalTime;

public class TimeProvider {
    public int getCurrentHour() {
        return LocalTime.now().getHour();
    }
}
