package com.example.consumermodule.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "orders")
public class Order {

    private String name;

    @Field
    private Integer amount;

    @NonNull
    @Field
    private Double totalCost;

    @NonNull
    @Field
    private String email;
}
