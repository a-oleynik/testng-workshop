package com.oleynik.qa.workshop.testng.ddt;

import com.oleynik.qa.workshop.testng.Factorial;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StaticDataProviderTest {

    @DataProvider(name = "factorial")
    public static Object[][] multiplyNumbers() {
        return new Object[][]{{1,1},{2,2},{3,6},{4,24},{5,120}};
    }

    @Test(dataProvider = "factorial")
    public void static_data_provider_test(long number, long expected){
        Assert.assertEquals(Factorial.factorial(number), expected, "Factorial function is wrong.");
    }
}
