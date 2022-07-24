package consumer.email;

import consumer.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HtmlBuilder {

    private String toString(Order order){
        return "name=" + order.getName() +
                ", amount=" + order.getAmount() +
                ", totalCost=" + order.getTotalCost();
    }

    public String getEmailBody(List<Order> orders) {
        StringBuilder body = new StringBuilder();
        body
                .append("<h3>Hello, dear client!</h3>")
                .append("<ol>Here are your orders:");
        orders.forEach(order -> body
                .append("<li>")
                .append(toString(order))
                .append("</li>"));
        body
                .append("</ol>")
                .append("Have a good day!");
        return body.toString();
    }
}
