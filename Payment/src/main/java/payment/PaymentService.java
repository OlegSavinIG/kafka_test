package payment;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    @KafkaListener(topics = "new_orders")
    public void processPayment(ConsumerRecord<String, String> record) throws InterruptedException {
        String value = record.value();
        System.out.println("Value received "+value);
        Thread.sleep(1000);
        kafkaTemplate.send("payed_orders", value + "payment successful");
    }

}
