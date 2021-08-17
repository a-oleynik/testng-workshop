package com.oleynik.qa.workshop.testng.general;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ExceptionTest {

    @Test(expectedExceptions = ArithmeticException.class)
    public void division_with_exception_test(){
        int i = 1/0;
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class,
            expectedExceptionsMessageRegExp = "Index 0 out of bounds for length 0")
    public void exception_with_message_test(){
        new ArrayList<String>().get(0);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class,
            expectedExceptionsMessageRegExp = ".* out of bounds for length 0")
    public void exception_with_message_regex_test(){
        new ArrayList<String>().get(0);
    }

    @Test
    public void exception_message_and_fail_test(){
        try {
            new ArrayList<String>().get(0);
        } catch (IndexOutOfBoundsException exception){
            Assert.assertEquals(exception.getMessage(), "Index 0 out of bounds for length 0");
            if (!(exception instanceof IndexOutOfBoundsException)) {
                Assert.fail(exception.getMessage());
            }
        }
    }
}

