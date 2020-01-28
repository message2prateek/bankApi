package com.chaapu.springstarter.account;

import com.chaapu.springstarter.customer.Customer;
import com.chaapu.springstarter.customer.CustomerType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@JacksonXmlRootElement
public class Account {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String type;

    private String status;

    @Min(50)
    @Max(10000)
    private double balance;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;

    public Account() {
    }

    public Account(int id, String name, String type, String status, double balance, int customerId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.balance = balance;
        this.customer = new Customer(customerId, "", CustomerType.Business);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
