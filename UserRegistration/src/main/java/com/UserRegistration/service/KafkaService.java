package com.UserRegistration.service;

import com.UserRegistration.Config.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
   @Autowired
   private KafkaTemplate<String,String> kafkaTemplate;

   public void sendUserRegisteredEvent(String userMailId){

       kafkaTemplate.send(AppConstants.TOPIC_NAME,userMailId);
   }

}
