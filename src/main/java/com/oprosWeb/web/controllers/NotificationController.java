package com.oprosWeb.web.controllers;

import com.oprosWeb.web.models.NotificationModel;
import com.oprosWeb.web.models.UserModel;
import com.oprosWeb.web.services.NotificationService;
import com.oprosWeb.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/notifications")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllNotifications(Model model) {
        List<NotificationModel> notifications = notificationService.getAllNotifications();
        model.addAttribute("notifications", notifications);
        model.addAttribute("notification", new NotificationModel());
        return "notifications";
    }

    @PostMapping("/add")
    public String createNotification(@ModelAttribute NotificationModel notification, RedirectAttributes redirectAttributes) {
        UserModel currentUser = userService.getCurrentUser();
        notification.setUser(currentUser);
        notification.setCreatedAt(LocalDateTime.now());
        notificationService.saveNotification(notification);
        redirectAttributes.addFlashAttribute("message", "Уведомление успешно добавлено!");
        return "redirect:/notifications";
    }

    @PostMapping ("/delete")
    public String deleteNotification(@RequestParam Long id) {
        notificationService.deleteNotification(id);
        return "redirect:/notifications";
    }
}
