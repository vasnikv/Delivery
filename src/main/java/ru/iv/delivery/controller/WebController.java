package ru.iv.delivery.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.iv.delivapi.view.PersonView;
import ru.iv.delivery.entity.*;
import ru.iv.delivery.repository.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WebController {
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
    StagesRepository stagesRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    GendersRepository gendersRepository;

    @Autowired
    ClientsRepository clientsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("/persons")
    public String showAllPersons(Model model) {
        //BeanUtils.copyProperties(persons, personsRepository.findAll());
        ModelMapper modelMapper = new ModelMapper();
        List<Person> persons = personsRepository.findAll();
        List<PersonView> personsview = new ArrayList<>();
        persons.forEach(person -> {
            personsview.add(modelMapper.map(person, PersonView.class));
        });
        model.addAttribute("persons", personsview);
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
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (person.getPassword().length() < 60) {
            person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
        }
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

    //--------------------------------------------

    @GetMapping("/stages")
    public String showAllStages(Model model) {
        model.addAttribute("stages", stagesRepository.findAll());
        return "stages";
    }

    @GetMapping("/stages/create")
    public String showCreateStageForm(Model model) {
        // TODO переделать все сущности в модель на вьюхи в модель, нельзя напрямую кидать сущность в отображение
        model.addAttribute("stage", new Stage());
        return "stagesCreate";
    }

    @GetMapping("/stages/edit/{stageId}")
    public String showEditStageForm(@PathVariable Long stageId, Model model) {
        // TODO переделать все сущности в модель на вьюхи в модель, нельзя напрямую кидать сущность в отображение
        Stage stage = stagesRepository.findById(stageId).orElse(new Stage());
        model.addAttribute("stage", stage);
        return "stagesCreate";
    }

    @PostMapping("/stages/save")
    public String saveStage(@ModelAttribute Stage stage, Model model) {
        stagesRepository.save(stage);
        model.addAttribute("stages", stagesRepository.findAll());
        return "redirect:/stages";
    }

    //------------------------------------------

    @GetMapping("/orders")
    public String showAllOrders(Model model) {
        model.addAttribute("orders", ordersRepository.findAll());
        return "orders";
    }

    @GetMapping("/orders/create")
    public String showCreateOrderForm(Model model) {
        // TODO переделать все сущности в модель на вьюхи в модель, нельзя напрямую кидать сущность в отображение
        model.addAttribute("order", new Order());
        return "ordersCreate";
    }

    @GetMapping("/orders/edit/{orderId}")
    public String showEditOrderForm(@PathVariable Long orderId, Model model) {
        // TODO переделать все сущности в модель на вьюхи в модель, нельзя напрямую кидать сущность в отображение
        Order order = ordersRepository.findById(orderId).orElse(new Order());
        model.addAttribute("order", order);
        return "ordersCreate";
    }

    @PostMapping("/orders/save")
    public String saveOrder(@ModelAttribute Order order, Model model) {
        ordersRepository.save(order);
        model.addAttribute("orders", ordersRepository.findAll());
        return "redirect:/orders";
    }
    //-------------------------------------------------------------------------

    @GetMapping("/rest")
    public List<Client> searchClientName(String name) {
        List<Client> clients = clientsRepository.searchClientName(name);
        return clients;
    }
}