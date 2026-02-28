package com.example.library_management.controller;

import org.springframework.ui.Model;
import com.example.library_management.model.User;
import com.example.library_management.service.UserService;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @Valid @ModelAttribute("user") User user,
            BindingResult result){

        if(result.hasErrors()){
            return "register";
        }

        userService.register(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(
            @RequestParam String email,
            @RequestParam String password,
            Model model){

        User user = userService.login(email,password);

        if(user == null){
            model.addAttribute("error","Invalid credentials");
            return "login";
        }

        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
