package ru.iv.repository;

import org.springframework.beans.factory.annotation.Autowired;
import ru.iv.entity.Gender;
import ru.iv.entity.Position;

//@Component
public class AfterConstruct {

    @Autowired
    PositionsRepository positionsRepository;

    @Autowired
    GendersRepository gendersRepository;

    //@PostConstruct
    public void init(){
        gendersRepository.save(new Gender(1L,"Мужской","M"));
        gendersRepository.save(new Gender(2L,"Женский","Ж"));

        positionsRepository.save(new Position("Директор","Д"));
        positionsRepository.save(new Position("Заместитель директора","ЗД"));
    }
}
