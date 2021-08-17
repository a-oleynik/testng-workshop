package com.oleynik.qa.workshop.testng.ddt;

import com.oleynik.qa.workshop.testng.Factorial;
import com.oleynik.qa.workshop.testng.annotations.DataSource;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static com.oleynik.qa.workshop.testng.dataproviders.MyDataProvider.getDataSourcePathFromMethod;

public class DynamicDataProviderTest {

    @DataProvider(name = "factorialFromFile")
    public static Iterator<Object[]> factorialDataFromFile(Method method) {
        try {
            String dataSource = getDataSourcePathFromMethod(method);
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(dataSource))
                    .build();
            List<String[]> allData = csvReader.readAll();
            return allData
                    .stream()
                    .map(e -> Arrays.stream(e)
                            .map(Long::parseLong)
                            .toArray())
                    .collect(Collectors.toList())
                    .iterator();
        } catch (IOException | NumberFormatException | CsvException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Test(dataProvider = "factorialFromFile")
    @DataSource(path = "src/test/resources/numbers.csv")
    public void dynamic_data_provider_test(long number, long expected) {
        Assert.assertEquals(Factorial.factorial(number), expected, "Factorial function is wrong.");
    }
}
