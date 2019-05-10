package org.otus.springframework.homework1.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question {
    private String text;
    private List<Answer> answers;
    private int userAnswerId;

    public Question() {
    }

    public Question(String[] question) {
        this.text = question[0];
        answers = new ArrayList<>();
        int correctAnswerId = Integer.parseInt(question[5]);
        for (int i = 1; i <= 4; i++) {
            Answer answer = new Answer();
            answer.setId(i);
            answer.setText(question[i]);
            if (correctAnswerId == i) {
                answer.setCorrect(true);
            }
            answers.add(answer);
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public int getUserAnswerId() {
        return userAnswerId;
    }

    public void setUserAnswerId(int userAnswerId) {
        this.userAnswerId = userAnswerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(text, question.text) &&
                Objects.equals(userAnswerId, question.userAnswerId) &&
                Objects.equals(answers, question.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, userAnswerId, answers);
    }

    @Override
    public String toString() {
        return "Question{" +
                "text='" + text + '\'' +
                ", userAnswerId=" + userAnswerId +
                ", answers=" + answers +
                '}';
    }
}
