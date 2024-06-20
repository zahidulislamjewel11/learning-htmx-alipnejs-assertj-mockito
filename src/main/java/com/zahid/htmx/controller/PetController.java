package com.zahid.htmx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/pets")
public class PetController {

    @GetMapping
    public String getTodos(Model model) {
        return "pets/pet-list";
    }
}
