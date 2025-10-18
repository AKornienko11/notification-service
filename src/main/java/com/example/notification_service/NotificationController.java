package com.example.notification_service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final EmailService emailService;

    public NotificationController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-welcome-mail")
    public ResponseEntity<Void> sendWelcomeEmail(@RequestParam String email) {
        emailService.sendEmail(email, "Добрый день! Ваш аккаунт успешно создан.");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/send-deletion-mail")
    public ResponseEntity<Void> sendDeletionEmail(@RequestParam String email) {
        emailService.sendEmail(email, "Добрый день! Ваш аккаунт был удалён.");
        return ResponseEntity.ok().build();
    }

}
