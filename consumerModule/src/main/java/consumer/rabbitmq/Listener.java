package consumer.rabbitmq;

import consumer.model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Listener {
    private final List<Order> currentOrdersQueue = new ArrayList<>();

    @RabbitListener(queues = "${queueName}")
    public void listener(Order order){
        currentOrdersQueue.add(order);
        System.out.println(order);
    }

    public List<Order> getQueue() {
        return currentOrdersQueue;
    }
}
