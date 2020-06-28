package ru.iv.entity;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESSES")
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "location", length = 256)
    public String location;

    @Column(name = "point_of_issue", columnDefinition = "boolean default false")
    private Boolean pointOfIssue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getPointOfIssue() {
        return pointOfIssue;
    }

    public void setPointOfIssue(Boolean pointOfIssue) {
        this.pointOfIssue = pointOfIssue;
    }
}
