package com.codedecode.order.dto;

// true replication of entity

import java.util.List;

public class OrderDTO {
    private Integer orderId;
    private List<FoodItemsDTO> foodItemsList;
    private RestaurantDTO restaurantDTO;
    private UserDTO userDTO;

}
