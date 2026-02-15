package com.EmailService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @Autowired
    private MailService mailService;

    @KafkaListener(topics = "user-registered",groupId = "mail-service-group")
    public void Consumer(String mailId){
        System.out.println("✅ Received mail ID from Kafka: " + mailId);
        mailService.sendRegistrationMail(mailId);
        System.out.println("📧 Sending registration email to " + mailId);

    }
}
