package payment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    @KafkaListener(topics = "new_orders", groupId = "payment_group")
    public void processPayment(String order) {
        System.out.println("Processing payment for order: " + order);
        kafkaTemplate.send("payed_orders", order + " payed, ");
    }

}
