package org.otus.springframework.homework1.service;

import org.otus.springframework.homework1.entity.Question;
import org.otus.springframework.homework1.entity.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestServiceImpl implements TestService {
    private final CSVService csvService;
    private final BufferedReader reader;

    public TestServiceImpl(CSVService csvService) {
        this.csvService = csvService;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public Test loadTest(String fileName) {
        List<String[]> testCSV = csvService.loadCSVFile(fileName);
        Test test = new Test();
        List<Question> questions = new ArrayList<>();
        test.setQuestions(questions);
        testCSV.forEach(questionCSV -> {
            Question question = new Question(questionCSV);
            questions.add(question);
        });
        return test;
    }

    @Override
    public void requestFirstName(Test test) {
        System.out.println("Введите Ваше имя:");
        try {
            String firstName = reader.readLine();
            test.setFirstName(firstName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void requestLastName(Test test) {
        System.out.println("Введите Вашу фамилию:");
        try {
            String lastName = reader.readLine();
            test.setLastName(lastName);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void requestQuestions(Test test) {

        test.getQuestions().forEach(question -> {
            System.out.println(question.getText());
            question.getAnswers().forEach(answer -> System.out.println(answer.getId() + " " + answer.getText()));
            try {
                int answer = Integer.parseInt(reader.readLine());
                if (answer > 0 && answer <= 4) {
                    question.setUserAnswerId(answer);
                    if (question.getAnswers().get(answer - 1).isCorrect()) {
                        System.out.println("Верно");
                        test.setCountCorrectAnswer(test.getCountCorrectAnswer() + 1);
                    } else {
                        System.out.println("Неверно");
                    }
                } else {
                    System.out.println("Некорркетное значение! Попробуйте еще раз");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void printResult(Test test) {
        System.out.println("Правильно " + test.getCountCorrectAnswer() + "/" + test.getQuestions().size());
    }
}
