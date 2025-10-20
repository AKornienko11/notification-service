package com.example.notification_service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmailServiceTest {
    @InjectMocks
    private EmailService emailService;

    @Mock
    private JavaMailSender mailSender;

    @Test
    public void testSendEmail() {

        String mail = "test@example.com";
        String message = "This is a test email.";
        doNothing().when(mailSender).send(any(SimpleMailMessage.class));
        emailService.sendEmail(mail,message);
        verify(mailSender).send(any(SimpleMailMessage.class));
    }
}