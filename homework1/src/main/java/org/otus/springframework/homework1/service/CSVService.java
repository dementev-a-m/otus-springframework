package org.otus.springframework.homework1.service;

import java.util.List;

public interface CSVService {
    List<String[]> loadCSVFile(String name);
}
