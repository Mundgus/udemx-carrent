package hu.mundgus.udemxcarrent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }
}