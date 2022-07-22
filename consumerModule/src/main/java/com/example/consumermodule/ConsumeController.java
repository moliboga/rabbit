package com.example.consumermodule;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ConsumeController {

    private List<Order> currentOrdersQueue = new ArrayList<>();

    @RabbitListener(queues = "${queueName}")
    public void listener(Order order){
        currentOrdersQueue.add(order);
        System.out.println(order);
    }

    @GetMapping("/consume")
    public List<Order> handleQueue(){
        List<Order> returnList = currentOrdersQueue;
        currentOrdersQueue = new ArrayList<>();
        return returnList;
    }
}
