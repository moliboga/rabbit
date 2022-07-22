package com.example.consumermodule.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {

    private String name;
    private Integer amount;

    @NonNull
    private Double totalCost;

    @NonNull
    private String email;
}
