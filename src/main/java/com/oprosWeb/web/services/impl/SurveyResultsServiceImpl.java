package com.oprosWeb.web.services.impl;

import com.oprosWeb.web.models.SurveyResultsModel;
import com.oprosWeb.web.repositories.SurveyResultsRepository;
import com.oprosWeb.web.services.SurveyResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyResultsServiceImpl implements SurveyResultsService {

    @Autowired
    private SurveyResultsRepository surveyResultsRepository;

    @Override
    public SurveyResultsModel saveSurveyResults(SurveyResultsModel surveyResults) {
        return surveyResultsRepository.save(surveyResults);
    }

    @Override
    public SurveyResultsModel getSurveyResultsById(Long resultId) {
        return surveyResultsRepository.findById(resultId).orElse(null);
    }

    @Override
    public List<SurveyResultsModel> getAllSurveyResults() {
        return surveyResultsRepository.findAll();
    }

    @Override
    public SurveyResultsModel updateSurveyResults(SurveyResultsModel surveyResults) {
        return surveyResultsRepository.save(surveyResults);
    }

    @Override
    public void deleteSurveyResults(Long resultId) {
        surveyResultsRepository.deleteById(resultId);
    }
}
