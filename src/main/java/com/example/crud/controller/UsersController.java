package com.example.crud.controller;

import com.example.crud.model.UsersModel;
import com.example.crud.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    @Autowired
    private final UsersServices usersServices;

    public UsersController(UsersServices usersServices) {
        this.usersServices = usersServices;
    }


    @RequestMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new UsersController(usersServices));
        return "register";
    }


    @RequestMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new UsersModel());
        return "login";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute UsersModel usersModel){
        System.out.println("Register request : " + usersModel );
        UsersModel registeredUser = usersServices.RegiserUser(usersModel.getLogin(), usersModel.getPassword(), usersModel.getEmail());
        return registeredUser == null ? "error_page" : "redirect/login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute UsersModel usersModel, Model model){
        System.out.println("Login request : " + usersModel );
        UsersModel authenticated = usersServices.authenticate(usersModel.getLogin(), usersModel.getPassword());
        if (authenticated != null){
            model.addAttribute("userLogin", authenticated.getLogin());
            return "personal_page";
        }else {
            return "error_page";
        }
    }

}
