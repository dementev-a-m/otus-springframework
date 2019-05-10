package org.otus.springframework.homework1.service;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVServiceImpl implements CSVService {

    @Override
    public List<String[]> loadCSVFile(String fileName) {
        try {
            CSVReader reader = new CSVReader(new FileReader(fileName));
            return reader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
