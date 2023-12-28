package com.ecommerce.website.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Consumer {

	@Value("${notification.topic.name:notificationCustomer}")
	private String notificationTopicName;

	@Value("${spring.kafka.consumer-group-id}")
	private String notificationGroupId;
	@KafkaListener(topics = "${notification.topic.name}",groupId = "${spring.kafka.consumer-group-id}")
	public void sendNotifications(String message) {
		log.info("Inside kafka listener . topicName: {} ,Request received is {}",
				notificationTopicName, message);
		
	}
}
