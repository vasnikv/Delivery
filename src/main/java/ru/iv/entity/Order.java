package ru.iv.entity;


import org.springframework.format.annotation.DateTimeFormat;
import ru.iv.converter.LocalDateAttributeConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * заказ
 */
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "number", length = 128)
    private String number;

    @Column(name = "order_date")
    @Convert(converter = LocalDateAttributeConverter.class)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate orderDate; //дата время заказа

    @Column(name = "delivery_date")
    @Convert(converter = LocalDateAttributeConverter.class)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate deliveryDate; //дата время доставки

    @Column(name = "start_date")
    @Convert(converter = LocalDateAttributeConverter.class)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate; //дата время начала приготовления

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "dish_id")

    @Transient
    private List<OrderDish> orderDishes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @Transient
    private List<OrderStage> orderStages;

    //TODO способ передачи заказа. например самовывоз/доставка/ожидание. надо ли???

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "description", length = 2048)
    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public List<OrderDish> getOrderDishes() {
        return orderDishes;
    }

    public void setOrderDishes(List<OrderDish> orderDishes) {
        this.orderDishes = orderDishes;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderStage> getOrderStages() {
        return orderStages;
    }

    public void setOrderStages(List<OrderStage> orderStages) {
        this.orderStages = orderStages;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
