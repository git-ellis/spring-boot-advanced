package com.example.demo.web;

import com.example.demo.domain.Client;
import com.example.demo.form.ClientForm;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private ClientService cs;

    @GetMapping("/registration")
    public String showRegistrationPage() {
        return "registration";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

//    @PostMapping("/login")
//    public String login(@RequestParam String name, @RequestParam String password) {
//
//    }

    @PostMapping("/register")
    public String register(ClientForm form) {
        Client client = form.covert();
        cs.addClient(client);
        return "redirect:/login";
    }
}
