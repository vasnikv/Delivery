package ru.iv.entity

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

// https://api.elephantsql.com/console/718afc0a-dfdc-43b9-bf85-f0d5af418983/browser?
//https://api.elephantsql.com/console/718afc0a-dfdc-43b9-bf85-f0d5af418983/browser
//insert into public.persons (firstname, middlename, lastname, gender, birthdate, position, empldate) values ('Ivan','Ivanovich', 'Ivanov', 'M', '1980-01-01', 'boss', '2000-01-01');
//https://www.codeflow.site/ru/article/thymeleaf-list

@Entity
@Table(name = "personsKotlin")
class PersonKotlin(
        @Id
        val id: Long,
        @Column
        var firstName: String,
        @Column
        var middleName: String,
        @Column
        var lastName: String,
        @Column
        var gender: String,
        @Column
        var birthDate: LocalDate,
        @Column
        var position: String,
        @Column
        var emplDate: LocalDate, // Дата приема
        @Column
        var dismDate: LocalDate // Дата увольнения
) {
    fun firstFunc(): String = "firstName=$firstName"

    fun secondFuncInc(i: Int) = i + 1
}
