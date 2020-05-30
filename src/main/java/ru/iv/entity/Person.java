package ru.iv.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "persons")
public class Person {

    // https://api.elephantsql.com/console/718afc0a-dfdc-43b9-bf85-f0d5af418983/browser?

    @Id
    private Long id;

    @Column
    public String firstName;

    @Column
    private String middleName;

    @Column
    private String lastName;

    @Column
    private String gender; // TODO справочник

    @Column
    private LocalDate birthDate;

    @Column
    private String position; // должность TODO справочник

    @Column
    private LocalDate EmplDate; // Дата приема

    @Column
    private LocalDate DismDate; // Дата увольнения

    //https://api.elephantsql.com/console/718afc0a-dfdc-43b9-bf85-f0d5af418983/browser
    //insert into public.persons (firstname, middlename, lastname, gender, birthdate, position, empldate) values ('Ivan','Ivanovich', 'Ivanov', 'M', '1980-01-01', 'boss', '2000-01-01');
    //https://www.codeflow.site/ru/article/thymeleaf-list


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getEmplDate() {
        return EmplDate;
    }

    public void setEmplDate(LocalDate emplDate) {
        EmplDate = emplDate;
    }

    public LocalDate getDismDate() {
        return DismDate;
    }

    public void setDismDate(LocalDate dismDate) {
        DismDate = dismDate;
    }
}
