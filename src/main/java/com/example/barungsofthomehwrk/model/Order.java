package com.example.barungsofthomehwrk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "Order")
public class Order {
    @Id
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
    private LocalDateTime date= LocalDateTime.now();
    private String customerId;
    private String description;
    private Double price;
    private int quantity;
}
