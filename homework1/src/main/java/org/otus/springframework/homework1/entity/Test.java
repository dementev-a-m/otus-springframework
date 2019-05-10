package org.otus.springframework.homework1.entity;

import java.util.List;
import java.util.Objects;

public class Test {
    private String firstName;
    private String lastName;
    private List<Question> questions;
    private int countCorrectAnswer;
    public Test() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getCountCorrectAnswer() {
        return countCorrectAnswer;
    }

    public void setCountCorrectAnswer(int countCorrectAnswer) {
        this.countCorrectAnswer = countCorrectAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return countCorrectAnswer == test.countCorrectAnswer &&
                Objects.equals(firstName, test.firstName) &&
                Objects.equals(lastName, test.lastName) &&
                Objects.equals(questions, test.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, questions, countCorrectAnswer);
    }

    @Override
    public String toString() {
        return "Test{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", questions=" + questions +
                ", countCorrectAnswer=" + countCorrectAnswer +
                '}';
    }
}
