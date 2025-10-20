package com.example.notification_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {
    private final EmailService emailService;

    @Autowired
    public NotificationListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "user-topic", groupId = "user-group")
    public void listen(String message) {

        if (message.startsWith("Created: ")) {
            String email = message.split(": ")[1];
            emailService.sendEmail(email, "Здравствуйте! Ваш аккаунт на сайте был успешно создан.");
        } else if (message.startsWith("Deleted: ")) {
            Long id = Long.valueOf(message.split(": ")[1]);
            String email = "aakornienko19901107@gmail.com";
            emailService.sendEmail(email, "Здравствуйте! Ваш аккаунт был удалён.");
        }
    }
}
