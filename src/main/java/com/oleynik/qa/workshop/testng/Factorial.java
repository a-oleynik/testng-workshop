package com.oleynik.qa.workshop.testng;

public class Factorial {
    public static long factorial(long number){
        if (number <= 1)
            return 1;
        else return (number * factorial(number - 1));
    }
}
