package com.oprosWeb.web.controllers;

import com.oprosWeb.web.models.CommentModel;
import com.oprosWeb.web.models.UserModel;
import com.oprosWeb.web.models.VoteModel;
import com.oprosWeb.web.services.CommentService;
import com.oprosWeb.web.services.UserService;
import com.oprosWeb.web.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private VoteService voteService;

    @Autowired
    private UserService userService;

    @GetMapping("/{voteId}")
    public String getCommentsByVote(@PathVariable Long voteId, Model model) {
        List<CommentModel> comments = commentService.getAllCommentsByVote(voteId);
        VoteModel vote = voteService.getVoteById(voteId);

        model.addAttribute("comments", comments);
        model.addAttribute("vote", vote);
        model.addAttribute("comment", new CommentModel());
        model.addAttribute("voteId", voteId);

        return "comments";
    }


    @PostMapping
    public String createComment(@ModelAttribute CommentModel comment, @RequestParam Long voteId, RedirectAttributes redirectAttributes) {
        comment.setCreatedAt(LocalDateTime.now());
        UserModel currentUser = userService.getCurrentUser();
        comment.setUser(currentUser);

        VoteModel vote = voteService.getVoteById(voteId);
        if (vote == null) {
            redirectAttributes.addFlashAttribute("error", "Голос не найден.");
            return "redirect:/comments";
        }

        comment.setVote(vote);

        commentService.saveComment(comment);

        redirectAttributes.addFlashAttribute("message", "Комментарий успешно добавлен!");
        return "redirect:/comments/" + voteId;
    }


    @PostMapping ("/delete")
    public String deleteComment(@RequestParam Long id) {
        commentService.deleteComment(id);
        return "redirect:/comments";
    }
}
