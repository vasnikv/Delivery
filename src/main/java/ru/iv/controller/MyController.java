package ru.iv.controller;

import org.springframework.stereotype.Controller;
import ru.iv.repository.PersonsRepository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @Autowired
    PersonsRepository personsRepository;

    @GetMapping("/persons")
    public String showAll(Model model) {
        model.addAttribute("persons", personsRepository.findAll());
        return "persons";
    }

}