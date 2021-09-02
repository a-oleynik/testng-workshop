package com.oleynik.qa.workshop.testng.model;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class MyDoubleWrapper {
    private double number;

    public double add(double anotherNumber) {
        return number + anotherNumber;
    }

    public double subtract(double anotherNumber) {
        return number - anotherNumber;
    }

    public double multiply(double anotherNumber) {
        return number * anotherNumber;
    }

    public double divide(double anotherNumber) {
        return number / anotherNumber;
    }

    public boolean isOdd() {
        return number % 2 != 0;
    }
}
