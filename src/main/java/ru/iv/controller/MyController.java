package ru.iv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    Logger logger = LoggerFactory.getLogger(this.getClass());

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
    public String showAllPersons(Model model) {
        model.addAttribute("persons", personsRepository.findAll());
        return "persons";
    }

    @GetMapping("/persons/create")
    public String showCreatePersonForm(Model model) {
        // TODO переделать все сущности в модель на вьюхи в модель, нельзя напрямую кидать сущность в отображение
        model.addAttribute("person", new Person());

        List<Position> positions = positionsRepository.findOnlyActive();
        Map<Long, String> mapPositions = new HashMap<>();
        positions.forEach(p -> mapPositions.put(p.getId(), p.getName()));
        model.addAttribute("mapPositions", mapPositions);

        List<Gender> genders = gendersRepository.findAll();
        Map<Long, String> mapGenders = new HashMap<>();
        genders.forEach(p -> mapGenders.put(p.getId(), p.getName()));
        model.addAttribute("mapGenders", mapGenders);

        return "personsCreate";
    }

    @GetMapping("/persons/edit/{personId}")
    public String showEditPersonForm(@PathVariable Long personId, Model model) {
        // TODO переделать все сущности в модель на вьюхи в модель, нельзя напрямую кидать сущность в отображение

        Person person = personsRepository.findById(personId).orElse(new Person());
        model.addAttribute("person", person);

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
    public String savePerson(@ModelAttribute Person person, Model model) {
        personsRepository.save(person);
        model.addAttribute("persons", personsRepository.findAll());
        return "redirect:/persons";
    }

    @GetMapping("/positions")
    public String showAllPositions(Model model) {
        model.addAttribute("positions", positionsRepository.findAll());
        return "positions";
    }

    @GetMapping("/positions/create")
    public String showCreatePositionForm(Model model) {
        // TODO переделать все сущности в модель на вьюхи в модель, нельзя напрямую кидать сущность в отображение
        model.addAttribute("position", new Position());
        return "positionsCreate";
    }

    @GetMapping("/positions/edit/{positionId}")
    public String showEditPositionForm(@PathVariable Long positionId, Model model) {
        // TODO переделать все сущности в модель на вьюхи в модель, нельзя напрямую кидать сущность в отображение
        Position position = positionsRepository.findById(positionId).orElse(new Position());
        model.addAttribute("position", position);
        return "positionsCreate";
    }

    @PostMapping("/positions/save")
    public String savePosition(@ModelAttribute Position position, Model model) {
        positionsRepository.save(position);
        model.addAttribute("positions", positionsRepository.findAll());
        return "redirect:/positions";
    }

}