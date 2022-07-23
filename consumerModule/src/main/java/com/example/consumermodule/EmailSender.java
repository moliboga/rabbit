package com.example.consumermodule;

import com.example.consumermodule.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmailSender {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendEmail(String toEmail, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
        System.out.println("Mail sent successfully.");
    }

    public void sendCurrent(List<Order> queue) {
        Map<String, List<Order>> emailsMap = new HashMap<>();
        queue.forEach(order -> {
            String email = order.getEmail();
            List<Order> orders = emailsMap.get(email);
            if (orders == null){
                orders = new ArrayList<>();
            } else {
                orders.add(order);
            }
            emailsMap.put(email, orders);
        });
        emailsMap.forEach((email, orders) -> {
            sendEmail(email, "Orders in current queue", "Anta baka?!");
        });
    }
}
