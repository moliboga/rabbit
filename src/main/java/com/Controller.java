package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Order order){
        rabbitMQSender.send(order);
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }
}
