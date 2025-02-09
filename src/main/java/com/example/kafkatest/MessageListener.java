package com.example.kafkatest;

import com.example.kafkatest.common.events.Notification;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {
    @KafkaListener(topics = "notifications", groupId = "notification-group")
    public void listen(ConsumerRecord<String, Notification> record) {
        Notification notification = record.value();
        System.out.println("Received Notification: " + notification);
    }
}
