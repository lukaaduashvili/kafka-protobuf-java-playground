package com.example.kafkatest;

import com.example.kafkatest.common.events.Notification;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("/v1/notifications")
public class MessageController {
    private final KafkaProducer<String, Notification> kafkaProducer;
    private static final String TOPIC = "notifications";

    @Autowired
    public MessageController(KafkaProducer<String, Notification> kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping
    public void sendNotification(@NotNull @RequestParam String message) {
        Notification notification = Notification.newBuilder().setId(UUID.randomUUID().toString()).setMessage(message).build();

        ProducerRecord<String, Notification> record = new ProducerRecord<>(TOPIC, notification.getId(), notification);
        kafkaProducer.send(record);
    }
}
