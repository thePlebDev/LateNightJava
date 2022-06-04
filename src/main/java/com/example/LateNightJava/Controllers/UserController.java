package com.example.LateNightJava.Controllers;

import com.example.LateNightJava.Models.User;
import com.example.LateNightJava.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public String getRegisterUser(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping("/success")
    public String handleRegistration(User user){
        userService.register(user);
        return "register_success";
    }

    @PostMapping("/profile")
    public String postLogin(User user){
        System.out.println(user.getPassword());
        System.out.println(user.getUsername());
        return "profile";
    }


    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("user",new User());
        return "login";
    }



}
