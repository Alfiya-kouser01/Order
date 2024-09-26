package com.codedecode.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import  java.util.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTOFromFrontend {

// below 3 thing we will get from front end
    private  List<FoodItemsDTO> foodItemsDTOList;
    private Integer userID;
    private RestaurantDTO restaurantDTO;



}
