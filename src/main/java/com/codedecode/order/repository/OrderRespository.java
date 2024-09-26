package com.codedecode.order.repository;

import com.codedecode.order.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRespository  extends MongoRepository<Order, Integer> {


}
