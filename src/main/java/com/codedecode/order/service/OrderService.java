package com.codedecode.order.service;

import com.codedecode.order.repository.OrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRespository orderRespository;

}
