package ru.iv.delivery.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.iv.delivery.entity.Client;

import javax.annotation.PostConstruct;

@Component
public class AfterConstruct {

    @Autowired
    PositionsRepository positionsRepository;

    @Autowired
    GendersRepository gendersRepository;

    @Autowired
    ClientsRepository clientsRepository;

    @PostConstruct
    public void init(){
        //gendersRepository.save(new Gender(1L,"Мужской","M"));
        //gendersRepository.save(new Gender(2L,"Женский","Ж"));

        //positionsRepository.save(new Position("Директор","Д"));
        //positionsRepository.save(new Position("Заместитель директора","ЗД"));

        clientsRepository.save(new Client("Вася","505050"));
        clientsRepository.save(new Client("Ваня","506070"));

    }
}
