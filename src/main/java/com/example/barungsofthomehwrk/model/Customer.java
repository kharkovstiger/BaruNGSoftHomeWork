package com.example.barungsofthomehwrk.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "Customer")
public class Customer implements Serializable{
    @Id
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private Integer age;

    public Customer() {
    }
}
