package com.example.barungsofthomehwrk.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Data
@Entity
public class Order {
    @Id
    private Long id;
    private LocalDate date;
//    @OneToOne
    private Long customerId;
    private String description;
    private Double price;
    private int quantity;
}
