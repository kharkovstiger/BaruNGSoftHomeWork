package com.example.barungsofthomehwrk.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Customer {
    @Id
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private int age;

    public Customer() {
    }
}
