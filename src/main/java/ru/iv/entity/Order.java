package ru.iv.entity;


import javax.persistence.*;

/**
 * заказ
 */
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
}
