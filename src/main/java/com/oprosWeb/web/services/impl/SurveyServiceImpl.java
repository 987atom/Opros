package com.oprosWeb.web.services.impl;

import com.oprosWeb.web.models.SurveyModel;
import com.oprosWeb.web.repositories.SurveyRepository;
import com.oprosWeb.web.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public SurveyModel saveSurvey(SurveyModel survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public SurveyModel getSurveyById(Long surveyId) {
        return surveyRepository.findById(surveyId).orElse(null);
    }

    @Override
    public List<SurveyModel> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    public SurveyModel updateSurvey(SurveyModel survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public void deleteSurvey(Long surveyId) {
        surveyRepository.deleteById(surveyId);
    }
}
