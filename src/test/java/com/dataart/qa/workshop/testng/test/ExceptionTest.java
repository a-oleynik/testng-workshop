package com.dataart.qa.workshop.testng.test;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ExceptionTest {

    @Test(expectedExceptions = ArithmeticException.class)
    public void test_dividing_with_exception(){
        int i = 1/0;
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class,
            expectedExceptionsMessageRegExp = "Index: 0, Size: 0")
    public void test_exception_with_message(){
        new ArrayList<String>().get(0);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class,
            expectedExceptionsMessageRegExp = ".* 0, Size: 0.*")
    public void test_exception_with_message2(){
        new ArrayList<String>().get(0);
    }

    @Test
    public void test_exception_message_and_fail(){
        try {
            new ArrayList<String>().get(0);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException){
            Assert.assertEquals(indexOutOfBoundsException.getMessage(), "Index: 0, Size: 0");
            Assert.fail(indexOutOfBoundsException.getMessage());
        }
    }
}

