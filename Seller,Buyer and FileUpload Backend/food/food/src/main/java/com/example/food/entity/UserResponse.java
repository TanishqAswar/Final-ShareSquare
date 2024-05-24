package com.example.food.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private long id;
    private String productType;
    private String productName;
    private int month;
    private Double rentingCost;
    private Double buyingCost;
    private double depositCost;
    private String image;

    // Constructor
    public UserResponse(long id, String productType, String productName, int month, Double rentingCost,
            Double buyingCost, double depositCost, String image) {
        this.id = id;
        this.productType = productType;
        this.productName = productName;
        this.month = month;
        this.rentingCost = rentingCost;
        this.buyingCost = buyingCost;
        this.depositCost = depositCost;
        this.image = image;
    }

    // Getters and Setters
    // ...
}
