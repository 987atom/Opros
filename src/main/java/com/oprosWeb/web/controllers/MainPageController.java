package com.oprosWeb.web.controllers;

import com.oprosWeb.web.models.CommentModel;
import com.oprosWeb.web.models.UserModel;
import com.oprosWeb.web.models.VoteModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/")
public class MainPageController {
    @GetMapping
    public String createComment() {
        return "redirect:/choices";
    }
}
