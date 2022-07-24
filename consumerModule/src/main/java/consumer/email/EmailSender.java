package consumer.email;

import consumer.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
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

    @Autowired
    private HtmlBuilder htmlBuilder;

    public void sendEmail(String toEmail, String subject, String body) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
        helper.setFrom(fromEmail);
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(body, true);
        javaMailSender.send(message);
        System.out.println("Mail sent successfully.");
    }

    public void sendCurrent(List<Order> queue) {
        Map<String, List<Order>> emailsMap = new HashMap<>();
        queue.forEach(order -> {
            String email = order.getEmail();
            List<Order> orders = emailsMap.get(email);
            if (orders == null) {
                orders = new ArrayList<>();
            }
            orders.add(order);
            emailsMap.put(email, orders);
        });
        emailsMap.forEach((email, orders) -> {
            try {
                sendEmail(email, "Orders in current queue", htmlBuilder.getEmailBody(orders));
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
