package com.oleynik.qa.workshop.testng.general;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HamcrestTest {
    @Test
    public void hamcrest_test() {
        System.out.println("The Hamcrest test");
        assertThat("Multiplication result is wrong", 2 * 5, equalTo(10));
        assertThat(2.0, is(10 / 5.0));
        boolean variable = true;
        assertThat("variable is not true", variable, is(true));
        assertThat("!variable is not false", !variable, is(not(true)));
        assertThat(2.0, is(closeTo(10 / 5.1, 0.1)));
        assertThat(2.0, is(both(greaterThan(10 / 5.1)).and(lessThan(10 / 4.9))));
    }
}
