package ru.iv.delivery.entity;

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

    @Column(name = "name", length = 128)
    private String name;

    @Column(name = "description", length = 2048)
    private String description;

    @Column(name = "ingridients", length = 8192)
    private String ingridients;

//    @Column(name = "minutes")
//    private Integer minutes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngridients() {
        return ingridients;
    }

    public void setIngridients(String ingridients) {
        this.ingridients = ingridients;
    }

//    public Integer getMinutes() {
//        return minutes;
//    }
//
//    public void setMinutes(Integer minutes) {
//        this.minutes = minutes;
//    }
}
