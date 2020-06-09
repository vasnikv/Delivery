package ru.iv.entity;

import javax.persistence.*;


/**
 * блюдо
 */
@Entity
@Table(name = "DISHES")
public class Dish {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

}
