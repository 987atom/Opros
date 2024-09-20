package com.oprosWeb.web.controllers;

import com.oprosWeb.web.models.SurveyResultsModel;
import com.oprosWeb.web.models.SurveyModel;
import com.oprosWeb.web.services.SurveyResultsService;
import com.oprosWeb.web.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/survey-results")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class SurveyResultsController {

    @Autowired
    private SurveyResultsService surveyResultsService;

    @Autowired
    private SurveyService surveyService;

    @GetMapping
    public String getAllSurveyResults(Model model) {
        List<SurveyResultsModel> surveyResults = surveyResultsService.getAllSurveyResults();
        List<SurveyModel> surveys = surveyService.getAllSurveys();
        model.addAttribute("surveyResults", surveyResults);
        model.addAttribute("surveys", surveys);
        model.addAttribute("surveyResult", new SurveyResultsModel());
        return "survey-results";
    }

    @PostMapping("/add")
    public String createSurveyResults(@ModelAttribute SurveyResultsModel surveyResult, RedirectAttributes redirectAttributes) {
        surveyResultsService.saveSurveyResults(surveyResult);
        redirectAttributes.addFlashAttribute("message", "Результат успешно добавлен!");
        return "redirect:/survey-results";
    }

    @PostMapping ("/delete")
    public String deleteSurveyResults(@RequestParam Long id) {
        surveyResultsService.deleteSurveyResults(id);
        return "redirect:/survey-results";
    }
}
