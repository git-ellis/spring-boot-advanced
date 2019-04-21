package com.example.demo.web;

import com.example.demo.domain.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService cs;

    @GetMapping("/all")
    public String showClients(Model model) {
        List<Client> clients = cs.getAllClient();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @GetMapping("/{id}")
    public String showClient(@PathVariable long id, Model model) {
        Client client = cs.getClientById(id);
        model.addAttribute("client", client);
        return "client";
    }
}
