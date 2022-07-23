package publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${exchange}")
    private String exchange;

    @Value("${routingKey}")
    private String routingKey;

    public void send(Order order) {
        rabbitTemplate.convertAndSend(exchange, routingKey, order);
        System.out.println("Send msg = " + order.toString());
    }
}
