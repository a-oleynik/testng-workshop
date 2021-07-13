package com.dataart.qa.workshop.testng.test;

import com.dataart.qa.workshop.Factorial;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParameterizationFromFileTest {

    @DataProvider(name = "factorialFromFile")
    public static Object[][] factorialDataFromFile() throws IOException, NumberFormatException, CsvValidationException {
        ArrayList<Object[]> outData = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader("src/test/resources/numbers.csv"));
            String [] data;
            while ((data = reader.readNext()) != null) {
                Object [] row = new Object[data.length];
                for (int i = 0; i <data.length ; i++) {
                    row[i] = Long.parseLong(data[i].trim());
                }
                outData.add(row);
            }
        } catch (IOException | NumberFormatException | CsvValidationException e) {
            e.printStackTrace();
            throw e;
        }
        return outData.toArray(new Object[outData.size()][]);
    }

    @Test(dataProvider = "factorialFromFile")
    public void test_factorial(long number, long expected){
        Assert.assertEquals(Factorial.factorial(number), expected, "Factorial function works wrong.");
    }
}
