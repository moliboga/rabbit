package com.consumer;

import com.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = "${queueName}")
    public void listener(Order order){
        System.out.println(order);
    }
}
