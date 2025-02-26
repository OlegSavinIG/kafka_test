package order.example.service;

import lombok.RequiredArgsConstructor;
import order.example.model.OrderRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    public void createOrder(String order) {
        System.out.println("Created order " + order);
        kafkaTemplate.send("new_orders", order + " created, ");
    }
}
