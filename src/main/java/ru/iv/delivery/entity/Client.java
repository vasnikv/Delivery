package ru.iv.delivery.entity;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTS")
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 128)
    private String name;

    @Column(name = "phone", length = 32)
    private String phone;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Client(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Client() {
    }

    //    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "actual_address_id")
//    private Address address;

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "address_id")
//    private List<Address> addresses;
}
