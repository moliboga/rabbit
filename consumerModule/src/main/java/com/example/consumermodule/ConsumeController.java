package com.example.consumermodule;

import com.example.consumermodule.model.Info;
import com.example.consumermodule.model.Order;
import com.example.consumermodule.mongo.MongoService;
import com.example.consumermodule.rabbitmq.Listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumeController {

    @Autowired
    private MongoService mongoService;
    @Autowired
    private Listener listener;
    @Autowired
    private EmailSender emailSender;

    @GetMapping("/consume")
    public String consume(){
        mongoService.addAll(listener.getQueue());
        emailSender.sendCurrent(listener.getQueue());
        listener.getQueue().clear();
        return "Orders were successfully consumed.";
    }

    @GetMapping("/info")
    public Info getInfo(){
        Info info = new Info();
        info.setConsumedOrders(this.getConsumedOrders());
        info.setUnconsumedOrders(listener.getQueue());
        return info;
    }

    private List<Order> getConsumedOrders() {
        return mongoService.getAll();
    }
}
