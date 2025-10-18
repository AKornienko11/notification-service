package com.example.notification_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class NotificationListener {
    private final EmailService emailService;

    @Autowired
    public NotificationListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "user-topic", groupId = "user-group")
    public void listen(String message) {
        // Разбор сообщения и отправка email в зависимости от операции
        if (message.startsWith("Created: ")) {
            String email = message.split(": ")[1];
            emailService.sendEmail(email, "Здравствуйте! Ваш аккаунт на сайте был успешно создан.");
        } else if (message.startsWith("Deleted: ")) {
            Long id = Long.valueOf(message.split(": ")[1]);
            // Получить email пользователя по ID (например, через репозиторий)
            String email = "example@example.com"; // Замените на реальную логику получения email.
            emailService.sendEmail(email, "Здравствуйте! Ваш аккаунт был удалён.");
        }

    }
}
