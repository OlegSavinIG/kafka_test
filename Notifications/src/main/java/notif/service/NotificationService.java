package notif.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    @KafkaListener(topics = "shipped_orders")
    public void sendNotification(ConsumerRecord<String, String> record){
        String value = record.value();
        log.info("Value for notification {}", value);
    }
}
