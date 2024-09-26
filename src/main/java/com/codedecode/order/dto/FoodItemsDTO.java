package com.codedecode.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemsDTO {
    private int id;
    private String name;
    private  String description;
    private boolean isVeg;
    private Double  price;
    private int restaurantId;
    private Integer quantity;
}

