package com.oprosWeb.web.controllers;

import com.oprosWeb.web.models.ChoiceModel;
import com.oprosWeb.web.models.QuestionModel;
import com.oprosWeb.web.models.UserModel;
import com.oprosWeb.web.models.VoteModel;
import com.oprosWeb.web.services.ChoiceService;
import com.oprosWeb.web.services.QuestionService;
import com.oprosWeb.web.services.UserService;
import com.oprosWeb.web.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/choices")

public class ChoiceController {

    @Autowired
    private VoteService voteService;

    @Autowired
    private ChoiceService choiceService;

    @Autowired
    private UserService userService;
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public String getAllChoices(Model model) {
        List<ChoiceModel> choices = choiceService.getAllChoices();
        List<QuestionModel> questions = questionService.getAllQuestions();
        model.addAttribute("questions", questions);
        model.addAttribute("choices", choices);
        model.addAttribute("choice", new ChoiceModel());
        return "choices";
    }

    @PostMapping("/add")
    public String createChoice(@ModelAttribute ChoiceModel choice, RedirectAttributes redirectAttributes) {
        Long questionId = choice.getQuestion().getQuestionId();
        QuestionModel question = questionService.getQuestionById(questionId);

        if (question == null) {
            redirectAttributes.addFlashAttribute("error", "Вопрос не найден.");
            return "redirect:/choices";
        }

        choice.setQuestion(question);
        choiceService.saveChoice(choice);

        redirectAttributes.addFlashAttribute("message", "Выбор успешно добавлен!");
        return "redirect:/choices";
    }



    @PostMapping("/edit/{id}")
    public String updateChoice(@PathVariable Long id, @ModelAttribute ChoiceModel choice) {
        choice.setChoiceId(id);
        choiceService.updateChoice(choice);
        return "redirect:/choices";
    }

    @GetMapping("/delete/{id}")
    public String deleteChoice(@PathVariable Long id) {
        choiceService.deleteChoice(id);
        return "redirect:/choices";
    }

    @PostMapping("/vote")
    public String vote(@RequestParam Long choiceId, @RequestParam boolean isFor, RedirectAttributes redirectAttributes) {
        // потом вернуть
        UserModel currentUser = userService.getCurrentUser();
//          UserModel currentUser = userService.getUserById(2L);

        // Находим выбор по его ID
        ChoiceModel choice = choiceService.getChoiceById(choiceId);
        if (choice == null) {
            redirectAttributes.addFlashAttribute("error", "Выбор не найден.");
            return "redirect:/choices";
        }

        VoteModel vote = new VoteModel();
        vote.setUser(currentUser);
        vote.setChoice(choice);
        vote.setCreatedAt(LocalDateTime.now());

        // Сохраняем голос в базе данных
        voteService.saveVote(vote);

        return "redirect:/choices";
    }

}
