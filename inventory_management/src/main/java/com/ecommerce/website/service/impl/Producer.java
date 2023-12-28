package com.ecommerce.website.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ecommerce.website.dto.NotificationDTO;
import com.ecommerce.website.enums.NotificationChannel;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Producer {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@Value("${notification.topic.name}")
	private String notificationTopicName;
	
	public void sendEmailSmsNotification(NotificationDTO notificationDTO) {
		notificationDTO.setNotificationChannel(NotificationChannel.EMAIL);
		sendMsgToTopic(notificationDTO);
		
	}

	private void sendMsgToTopic(NotificationDTO notificationDTO) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			kafkaTemplate.send(notificationTopicName,objectMapper.writeValueAsString(notificationDTO));
		} catch (Exception e) {
			log.info("Exception occurs in producer : {} , {}",e,e.getMessage());
		}
		
	}
}
