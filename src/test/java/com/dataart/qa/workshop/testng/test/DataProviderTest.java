package com.dataart.qa.workshop.testng.test;

import com.dataart.qa.workshop.Factorial;
import com.dataart.qa.workshop.testng.dataproviders.MyDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderTest {

    @Test(dataProvider = "factorialFromFile", dataProviderClass = MyDataProvider.class)
    public void test_factorial(long number, long expected){
        Assert.assertEquals(Factorial.factorial(number), expected, "Factorial function works wrong.");
    }
}
