package ru.iv.delivery.entity;

import javax.persistence.*;

@Entity
@Table(name = "GENDERS")
public class Gender {
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 10)
    private String name;

    @Column(name = "short_name", length = 1)
    private String shortName;

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Gender(Long id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }

    public Gender() {
    }


}
