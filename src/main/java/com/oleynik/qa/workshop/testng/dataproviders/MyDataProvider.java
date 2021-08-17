package com.oleynik.qa.workshop.testng.dataproviders;

import com.oleynik.qa.workshop.testng.annotations.DataSource;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class MyDataProvider {
    @DataProvider(name = "factorialFromFile")
    public static Object[][] factorialDataFromFile(Method method) {
        try {
            String dataSource = getDataSourcePathFromMethod(method);
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(dataSource))
                    .build();
            List<String[]> allData = csvReader.readAll();
            return allData
                    .stream()
                    .map(e -> Arrays.stream(e)
                            .map(num -> (Object) Long.parseLong(num))
                            .toArray())
                    .toArray(Object[][]::new);
        } catch (IOException | NumberFormatException | CsvException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static String getDataSourcePathFromMethod(Method method) {
        if (method.isAnnotationPresent(DataSource.class)) {
            DataSource annotation = method.getAnnotation(DataSource.class);
            return annotation.path();
        } else {
            throw new RuntimeException("DataSource annotation is not found");
        }
    }
}
