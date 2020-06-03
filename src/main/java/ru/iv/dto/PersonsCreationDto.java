package ru.iv.dto;

import ru.iv.entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vv on 01.06.2020.
 */
public class PersonsCreationDto {
    private List<Person> persons = new ArrayList<>();
//    private Person person = new Person();

    //default and parameterized constructor

    public void addPerson(Person person) {
        persons.add(person);
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }
}
