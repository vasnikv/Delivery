package ru.iv.delivery.entity;

import javax.persistence.*;

@Entity
@Table(name = "POSITIONS")
public class Position {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 128)
    public String name;

    @Column(name = "short_name", length = 32)
    private String shortName;

    @Column(name = "active", columnDefinition = "boolean default false")
    private Boolean active;

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Position(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public Position() {
    }
}
