package com.example.springsamples.orders;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderModel {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    public String id;

    @Column(name = "alias")
    public String alias;

    @Column(name = "address")
    public String address;

    @Column(name = "order_date")
    public String order_date;

    @Column(name = "orderDescription")
    public String orderDescription;

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    @Column(name = "restaurant")
    public String restaurant;
}
