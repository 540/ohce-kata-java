package com.deg540.tdd;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorShould {

    @Test
    public void add_two_numbers() throws Exception {
        Calculator calculator = new Calculator();

        int result = calculator.add(1, 2);

        assertThat(result, is(3));
    }

    @Test
    public void multiply_two_numbers() throws Exception {
        Calculator calculator = new Calculator();

        int result = calculator.multiply(1, 2);

        assertThat(result, is(2));
    }


}

