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
    @KafkaListener(topics = "new_orders")
    public void processPayment(String order) throws InterruptedException {
//        String value = record.value();
        log.info("Value received");
        log.info("Value received {}", order);
        log.info("Value received {}", order);
        log.info("Value received {}", order);
//        Thread.sleep(500);
        kafkaTemplate.send("payed_orders", order + "payment successful");
    }

}
