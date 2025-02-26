package shipping.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShippingService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    @KafkaListener(topics = "payed_orders", groupId = "shipping_group")
    public void shipOrder(String order) {
        System.out.println("Shipping order: " + order);
        kafkaTemplate.send("sent_orders", order + " shipped, ");
    }
}
