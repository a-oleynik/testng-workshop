package com.oleynik.qa.workshop.testng;


public class Utils {
    public static void waitFor(int timeoutInSeconds) {
        try {
            Thread.sleep(timeoutInSeconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
