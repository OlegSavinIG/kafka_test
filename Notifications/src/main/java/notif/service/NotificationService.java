package notif.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    @KafkaListener(topics = "sent_orders", groupId = "notification_group")
    public void notifyUser(String order) {
        System.out.println("Order delivered notification sent for: " + order);
    }
}
