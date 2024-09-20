package com.oprosWeb.web.controllers;

import com.oprosWeb.web.models.QuestionModel;
import com.oprosWeb.web.models.SurveyModel;
import com.oprosWeb.web.services.QuestionService;
import com.oprosWeb.web.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/questions")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private SurveyService surveyService;

    @GetMapping
    public String getAllQuestions(Model model) {
        List<SurveyModel> surveys = surveyService.getAllSurveys();
        List<QuestionModel> questions = questionService.getAllQuestions();
        model.addAttribute("questions", questions);
        model.addAttribute("surveys", surveys); // Убедитесь, что опросы добавляются в модель
        model.addAttribute("question", new QuestionModel());
        return "questions";
    }


    @PostMapping("/add")
    public String createQuestion(@ModelAttribute QuestionModel question, RedirectAttributes redirectAttributes, Model model) {
        questionService.saveQuestion(question);
        List<QuestionModel> questions = questionService.getAllQuestions();
        model.addAttribute("questions", questions);
        redirectAttributes.addFlashAttribute("message", "Вопрос успешно добавлен!");
        return "redirect:/questions";
    }

    @PostMapping("/edit/{id}")
    public String updateQuestion(@PathVariable Long id, @ModelAttribute QuestionModel question) {
        question.setQuestionId(id);
        questionService.updateQuestion(question);
        return "redirect:/questions";
    }

    @PostMapping ("/delete")
    public String deleteQuestion(@RequestParam Long id) {
        questionService.deleteQuestion(id);
        return "redirect:/questions";
    }
}
