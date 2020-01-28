package com.chaapu.springstarter.customer;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement
public class CustomerList {

    @JacksonXmlElementWrapper(useWrapping = false)
    List<Customer> customers;

    public CustomerList(List<Customer> customers) {
        this.customers = customers;
    }

    public CustomerList() {
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
