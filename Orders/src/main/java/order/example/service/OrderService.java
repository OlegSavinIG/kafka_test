package order.example.service;

import lombok.RequiredArgsConstructor;
import order.example.model.OrderRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    public void createOrder(OrderRequest orderRequest) {
        System.out.println("Sending to payment");
        kafkaTemplate.send("new_orders", orderRequest.toString());
    }
}
