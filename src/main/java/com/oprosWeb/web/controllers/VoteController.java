package com.oprosWeb.web.controllers;

import com.oprosWeb.web.models.ChoiceModel;
import com.oprosWeb.web.models.UserModel;
import com.oprosWeb.web.models.VoteModel;
import com.oprosWeb.web.services.ChoiceService;
import com.oprosWeb.web.services.UserService;
import com.oprosWeb.web.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/votes")
//@PreAuthorize("hasAnyAuthority('MANAGER')")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class VoteController {
    @Autowired
    private UserService userService;
    @Autowired
    private ChoiceService choiceService;
    @Autowired
    private VoteService voteService;

    @GetMapping
    public String getAllVotes(Model model) {
        List<VoteModel> votes = voteService.getAllVotes();
        model.addAttribute("votes", votes);
        model.addAttribute("account_rol", SecurityContextHolder.getContext().getAuthentication().toString());
        return "votes";
    }

    @PostMapping
    public VoteModel createVote(@RequestBody VoteModel vote) {
        return voteService.saveVote(vote);
    }

    @PostMapping("/vote")
    public String vote(@RequestParam Long choiceId, @RequestParam boolean isFor, RedirectAttributes redirectAttributes) {
//        потом вернуть
        UserModel currentUser = userService.getCurrentUser();
//        UserModel currentUser = userService.getUserById(2L);

        ChoiceModel choice = choiceService.getChoiceById(choiceId);
        if (choice == null) {
            redirectAttributes.addFlashAttribute("error", "Выбор не найден.");
            return "redirect:/votes";
        }

        VoteModel vote = new VoteModel();
        vote.setUser(currentUser);
        vote.setChoice(choice);
        vote.setCreatedAt(LocalDateTime.now());

        voteService.saveVote(vote);

        redirectAttributes.addFlashAttribute("message", "Ваш голос был учтён успешно!");
        return "redirect:/votes";
    }
}
