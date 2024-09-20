//package com.oprosWeb.web.controllers;
//
//
//import com.oprosWeb.web.models.UserModel;
//import com.oprosWeb.web.models.RoleEnum;
//import com.oprosWeb.web.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.Collections;
//
//@Controller
//public class RegistrationController {
//    @Autowired
//    private UserRepository userRepos;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @GetMapping("/registration")
//    public String registrationView() {
//        return "regis";
//    }
//
//    @PostMapping("/registration")
//    public String registrationUser(UserModel user, Model model) {
//        if (userRepos.existsByUsername(user.getUsername())) {
//            model.addAttribute("message", "Пользователь уже существует");
//            return "regis";
//        }
//
//        if (user.getPasswordHash() == null || user.getPasswordHash().isEmpty()) {
//            model.addAttribute("message", "Пароль не может быть пустым");
//            return "regis";
//        }
//
//        user.setRole(Collections.singleton(RoleEnum.USER));
//        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
//        userRepos.save(user);
//        return "redirect:/login";
//    }
//
//}


package com.oprosWeb.web.controllers;

import com.oprosWeb.web.models.UserModel;
import com.oprosWeb.web.models.RoleEnum;
import com.oprosWeb.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepos;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registrationView() {
        return "regis";
    }

    @PostMapping("/registration")
    public String registrationUser(UserModel user,
                                   @RequestParam String role,
                                   Model model) {
        if (userRepos.existsByUsername(user.getUsername())) {
            model.addAttribute("message", "Пользователь уже существует");
            return "regis";
        }

        if (user.getPasswordHash() == null || user.getPasswordHash().isEmpty()) {
            model.addAttribute("message", "Пароль не может быть пустым");
            return "regis";
        }

        user.setRole(Collections.singleton(RoleEnum.valueOf(role))); // Установите роль на основе значения из выпадающего списка
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        userRepos.save(user);
        return "redirect:/login";
    }
}
