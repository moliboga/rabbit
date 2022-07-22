package com.example.consumermodule.mongo;

import com.example.consumermodule.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoService {

    @Autowired
    private MongoRepo mongoRepo;

    public void addAll(List<Order> orders){
        mongoRepo.saveAll(orders);
    }

    public List<Order> getAll() {
        return mongoRepo.findAll();
    }
}
