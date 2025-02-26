package order.example.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic newOrdersTopic() {
        return TopicBuilder.name("new_orders").partitions(3).replicas(1).build();
    }

    @Bean
    public NewTopic payedOrdersTopic() {
        return TopicBuilder.name("payed_orders").partitions(3).replicas(1).build();
    }

    @Bean
    public NewTopic sentOrdersTopic() {
        return TopicBuilder.name("sent_orders").partitions(3).replicas(1).build();
    }
}
