package com.example.demo.web;

import com.example.demo.domain.Client;
import com.example.demo.form.ClientForm;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private ClientService cs;

    @GetMapping("/registration")
    public String showRegistrationPage(Model model) {
        model.addAttribute("clientForm", new ClientForm());
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
    public String register(@Valid ClientForm clientForm, BindingResult br) {
        if (!clientForm.confirmPassword())
            br.rejectValue("confirmedPwd", "confirmedPwdError", "兩次密碼輸入不一致");
        if (br.hasErrors())
            return "registration";

//        if (br.hasErrors()) {
//            for (FieldError fe : br.getFieldErrors()) {
//                System.out.println("Field = " + fe.getField());
//                System.out.print(" Code = " + fe.getCode());
//                System.out.print(" DefaultMessage = " + fe.getDefaultMessage() + " \n");
//            }
//        }
//
        Client client = clientForm.covert();
        cs.addClient(client);
        return "redirect:/login";
    }

    @GetMapping("/exception")
    public String show500Page() {
        throw new RuntimeException();
    }
}
