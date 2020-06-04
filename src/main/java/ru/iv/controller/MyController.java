package ru.iv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.iv.dto.PersonsCreationDto;
import ru.iv.entity.Gender;
import ru.iv.entity.Person;
import ru.iv.entity.Position;
import ru.iv.repository.GendersRepository;
import ru.iv.repository.PersonsRepository;
import ru.iv.repository.PositionsRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyController {

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @Autowired
    PersonsRepository personsRepository;

    @Autowired
    PositionsRepository positionsRepository;

    @Autowired
    GendersRepository gendersRepository;

    @GetMapping("/persons")
    public String showAll(Model model) {
        model.addAttribute("persons", personsRepository.findAll());
        return "persons";
    }

    @GetMapping("/persons/create")
    public String showCreateForm(Model model) {
        // TODO переделать все сущности в модель на вьюхи в модель, нельзя напрямую кидать сущность в отображение
        PersonsCreationDto personsForm = new PersonsCreationDto();
        personsForm.addPerson(new Person());
        model.addAttribute("form", personsForm);

        List<Position> positions = positionsRepository.findAll();
        Map<Long, String> mapPositions = new HashMap<>();
        positions.forEach(p -> mapPositions.put(p.getId(), p.getName()));
        model.addAttribute("mapPositions", mapPositions);

        List<Gender> genders = gendersRepository.findAll();
        Map<Long, String> mapGenders = new HashMap<>();
        genders.forEach(p -> mapGenders.put(p.getId(), p.getName()));
        model.addAttribute("mapGenders", mapGenders);

        return "personsCreate";
    }

    @PostMapping("/persons/save")
    public String saveBooks(@ModelAttribute PersonsCreationDto form, Model model) {
        personsRepository.saveAll(form.getPersons());

        model.addAttribute("persons", personsRepository.findAll());
        return "redirect:/persons";
    }

}