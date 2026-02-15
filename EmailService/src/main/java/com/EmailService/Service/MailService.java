package com.EmailService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendRegistrationMail(String mailId){

        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(mailId);
        message.setSubject("Registration Successfull");
        message.setText(" You have been registered successfully!");

        mailSender.send(message);
        System.out.println("📧 Email sent to " + mailId);
    }
}