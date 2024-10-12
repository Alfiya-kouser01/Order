package com.codedecode.order.service;

import com.codedecode.order.Mapper.OrderMapper;
import com.codedecode.order.dto.OrderDTO;
import com.codedecode.order.dto.OrderDTOFromFrontend;
import com.codedecode.order.dto.UserDTO;
import com.codedecode.order.entity.Order;
import com.codedecode.order.repository.OrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    OrderRespository orderRespository;
    @Autowired
    SequencesGenerater sequencesGenerater;
    @Autowired
    RestTemplate restTemplate;

    public OrderDTO saveOrder(OrderDTOFromFrontend orderDetails) {

       Integer newOrderID = sequencesGenerater.generateNextOrderId();
        UserDTO userDTO = fetchOrderedUser(orderDetails.getUserID());

        Order orderToBeSaved = new Order(newOrderID,orderDetails.getFoodItemsDTOList(),orderDetails.getRestaurantDTO(),userDTO);
        orderRespository.save(orderToBeSaved);

        return OrderMapper.INSTANCE.mapOrderTOOrderDTO(orderToBeSaved);

    }

    private UserDTO fetchOrderedUser(int userID){
        return  restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userID,UserDTO.class);
    }
}
