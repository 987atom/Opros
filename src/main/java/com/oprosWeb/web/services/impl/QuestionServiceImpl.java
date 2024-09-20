package com.oprosWeb.web.services.impl;

import com.oprosWeb.web.models.QuestionModel;
import com.oprosWeb.web.repositories.QuestionRepository;
import com.oprosWeb.web.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public QuestionModel saveQuestion(QuestionModel question) {
        return questionRepository.save(question);
    }

    @Override
    public QuestionModel getQuestionById(Long questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }

    @Override
    public List<QuestionModel> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public QuestionModel updateQuestion(QuestionModel question) {
        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long questionId) {
        questionRepository.deleteById(questionId);
    }
}
