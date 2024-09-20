package com.oprosWeb.web.services;

import com.oprosWeb.web.models.SurveyResultsModel;

import java.util.List;

public interface SurveyResultsService {
    SurveyResultsModel saveSurveyResults(SurveyResultsModel surveyResults);
    SurveyResultsModel getSurveyResultsById(Long resultId);
    List<SurveyResultsModel> getAllSurveyResults();
    SurveyResultsModel updateSurveyResults(SurveyResultsModel surveyResults);
    void deleteSurveyResults(Long resultId);
}
