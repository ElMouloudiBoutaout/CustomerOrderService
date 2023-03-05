package com.customer.order.data;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    public Customer(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    private String email;

    @OneToMany(fetch=FetchType.LAZY)
    private List<CustomerOrder> customerOrders;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CustomerOrder> getOrders() {
        return customerOrders;
    }

    public void setOrders(List<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }
}
