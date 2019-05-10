package org.otus.springframework.homework1.service;

import org.otus.springframework.homework1.entity.Test;

public interface TestService {
    Test loadTest(String fileName);

    void requestFirstName(Test test);

    void requestLastName(Test test);

    void requestQuestions(Test test);

    void printResult(Test test);
}
