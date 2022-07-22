package com.example.consumermodule.mongo;

import com.example.consumermodule.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepo extends MongoRepository<Order, Long> {
}
