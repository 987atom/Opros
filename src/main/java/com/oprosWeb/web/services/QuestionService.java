package com.oprosWeb.web.services;

import com.oprosWeb.web.models.QuestionModel;

import java.util.List;

public interface QuestionService {
    QuestionModel saveQuestion(QuestionModel question);
    QuestionModel getQuestionById(Long questionId);
    List<QuestionModel> getAllQuestions();
    QuestionModel updateQuestion(QuestionModel question);
    void deleteQuestion(Long questionId);
}
