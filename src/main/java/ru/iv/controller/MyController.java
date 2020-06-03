package ru.iv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.iv.dto.PersonsCreationDto;
import ru.iv.entity.Person;
import ru.iv.repository.PersonsRepository;

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

    @GetMapping("/persons/create")
    public String showCreateForm(Model model) {
        PersonsCreationDto personsForm = new PersonsCreationDto();
        personsForm.addPerson(new Person());
        model.addAttribute("form", personsForm);
        return "personsCreate";
    }

    @PostMapping("/persons/save")
    public String saveBooks(@ModelAttribute PersonsCreationDto form, Model model) {
        personsRepository.saveAll(form.getPersons());

        model.addAttribute("persons", personsRepository.findAll());
        return "redirect:/persons";
    }

}