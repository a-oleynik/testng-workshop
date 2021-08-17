package com.oleynik.qa.workshop.testng.ddt;

import com.oleynik.qa.workshop.testng.Factorial;
import com.oleynik.qa.workshop.testng.annotations.DataSource;
import com.oleynik.qa.workshop.testng.dataproviders.MyDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OuterDataProviderTest {

    @Test(dataProvider = "factorialFromFile", dataProviderClass = MyDataProvider.class)
    @DataSource(path = "src/test/resources/numbers.csv")
    public void outer_data_provider_test(long number, long expected) {
        Assert.assertEquals(Factorial.factorial(number), expected, "Factorial function is wrong.");
    }
}
