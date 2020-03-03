package com.chaapu.springstarter.customer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@ApiModel(value = "Customer", description = "Customer information")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {
    @Id
    @Min(value = 100)
    @ApiModelProperty(value = "Unique ID for each Customer instance")
//    @GeneratedValue(strategy=SEQUENCE,generator = "seq")
//    @SequenceGenerator(name = "seq", initialValue = 103, sequenceName = "oracle_seq")
    private int id;


    @ApiModelProperty(value = "Name of the customer")
    private String name;

    @Enumerated(value = EnumType.STRING)
    @ApiModelProperty(value = "The type of customer")
    private CustomerType type;

    public Customer() {
    }

    public Customer(int id, String name, CustomerType type) {
        this.id = id;
        this.name = name;
        this.type = type;
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

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }
}
