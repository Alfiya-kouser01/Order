package com.codedecode.order.controller;


import com.codedecode.order.dto.OrderDTO;
import com.codedecode.order.dto.OrderDTOFromFrontend;
import com.codedecode.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    /// end point that save the order in order db of mongodb

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFrontend orderDetails){
        OrderDTO orderSavedinDB = orderService.saveOrder(orderDetails);
        return new ResponseEntity<>(orderSavedinDB, HttpStatus.CREATED);
    }
}
