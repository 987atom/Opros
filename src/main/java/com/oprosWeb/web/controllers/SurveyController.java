package com.oprosWeb.web.controllers;

import com.oprosWeb.web.models.SurveyModel;
import com.oprosWeb.web.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/surveys")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping
    public String getAllSurveys(Model model) {
        List<SurveyModel> surveys = surveyService.getAllSurveys();
        model.addAttribute("surveys", surveys);
        model.addAttribute("survey", new SurveyModel()); // для добавления нового опроса
        return "surveys"; // имя HTML-шаблона
    }

    @PostMapping("/add")
    public String createSurvey(@ModelAttribute SurveyModel survey, RedirectAttributes redirectAttributes) {
        surveyService.saveSurvey(survey);
        redirectAttributes.addFlashAttribute("message", "Опрос успешно добавлен!");
        return "redirect:/surveys";
    }

    @PostMapping ("/delete")
    public String deleteSurveyResults(@RequestParam Long id) {
        surveyService.deleteSurvey(id);
        return "redirect:/surveys";
    }
}
