package com.oprosWeb.web.services;

import com.oprosWeb.web.models.SurveyModel;

import java.util.List;

public interface SurveyService {
    SurveyModel saveSurvey(SurveyModel survey);
    SurveyModel getSurveyById(Long surveyId);
    List<SurveyModel> getAllSurveys();
    SurveyModel updateSurvey(SurveyModel survey);
    void deleteSurvey(Long surveyId);
}
