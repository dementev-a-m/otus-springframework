package org.otus.springframework.homework1;

import org.otus.springframework.homework1.entity.Test;
import org.otus.springframework.homework1.service.TestService;
import org.otus.springframework.homework1.service.TestServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        TestService testService = context.getBean(TestServiceImpl.class);
        Test test = testService.loadTest("test.csv");
        testService.requestFirstName(test);
        testService.requestLastName(test);
        testService.requestQuestions(test);
        testService.printResult(test);

    }
}
