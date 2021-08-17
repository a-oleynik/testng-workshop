package com.oleynik.qa.workshop.testng;

import com.oleynik.qa.workshop.testng.annotations.DataSource;
import com.oleynik.qa.workshop.testng.dataproviders.MyDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderTest {

    @Test(dataProvider = "factorialFromFile", dataProviderClass = MyDataProvider.class)
    @DataSource(path = "src/test/resources/numbers.csv")
    public void test_factorial(long number, long expected){
        Assert.assertEquals(Factorial.factorial(number), expected, "Factorial function works wrong.");
    }
}
