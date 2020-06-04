package ru.iv.entity;

import org.springframework.format.annotation.DateTimeFormat;
import ru.iv.converter.LocalDateAttributeConverter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PERSONS")
public class Person {

    // https://api.elephantsql.com/console/718afc0a-dfdc-43b9-bf85-f0d5af418983/browser?

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", length = 16)
    public String firstName;

    @Column(name = "middle_name", length = 16)
    private String middleName;

    @Column(name = "last_name", length = 16)
    private String lastName;

//    @Column(name = "gender", length = 10)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gender_id")
    private Gender gender; // TODO справочник

    @Column(name = "birth_date")
    @Convert(converter = LocalDateAttributeConverter.class)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;

//    @Column(name = "position_id", length = 32)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id")
    private Position position; // должность TODO справочник

    @Column(name = "empl_date")
    @Convert(converter = LocalDateAttributeConverter.class)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate emplDate; // Дата приема

    @Column(name = "dism_date")
    @Convert(converter = LocalDateAttributeConverter.class)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dismDate; // Дата увольнения

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public LocalDate getEmplDate() {
        return emplDate;
    }

    public void setEmplDate(LocalDate emplDate) {
        this.emplDate = emplDate;
    }

    public LocalDate getDismDate() {
        return dismDate;
    }

    public void setDismDate(LocalDate dismDate) {
        this.dismDate = dismDate;
    }
}
