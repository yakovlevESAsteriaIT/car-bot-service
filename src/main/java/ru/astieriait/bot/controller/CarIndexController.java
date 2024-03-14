package ru.astieriait.bot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*")
public class CarIndexController {
    @GetMapping("/")
    public String getIndex() {
        return "index.html";
    }
}
