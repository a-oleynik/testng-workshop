package com.dataart.qa.workshop.testng.dataproviders;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyDataProvider {
    @DataProvider(name = "factorialFromFile")
    public static Object[][] factorialDataFromFile() throws IOException, NumberFormatException, CsvValidationException {
        ArrayList<Object[]> outData = new ArrayList<>();
        try {
            CSVReader csvFile = new CSVReader(new FileReader("src/test/resources/numbers.csv"));
            String [] lines;
            while ((lines = csvFile.readNext()) != null) {
                Object [] cells = new Object[lines.length];
                for (int i = 0; i <lines.length ; i++) {
                    cells[i] = Long.parseLong(lines[i].trim());
                }
                outData.add(cells);
            }
        } catch (IOException | NumberFormatException | CsvValidationException e) {
            e.printStackTrace();
            throw e;
        }
        return outData.toArray(new Object[outData.size()][]);
    }
}
