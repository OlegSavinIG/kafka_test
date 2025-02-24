package shipping.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShippingService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    @KafkaListener(topics = "payed_orders")
    public void processPayment(ConsumerRecord<String, String> record) throws InterruptedException {
        String value = record.value();
        System.out.println("Value fo shipping received "+value);
        Thread.sleep(1000);
        kafkaTemplate.send("shipped_orders", value + "shipped");
    }
}
