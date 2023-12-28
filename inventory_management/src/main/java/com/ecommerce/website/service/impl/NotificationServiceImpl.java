package com.ecommerce.website.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.website.dto.NotificationDTO;
import com.ecommerce.website.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService{

	@Autowired
	private Producer producer;
	@Override
	public void prepareAndSendNotification(String agentEmail, String agentMobile, Map<String, Object> parameterMap) {
		
		NotificationDTO notificationDTO = NotificationDTO.builder()
				.email(agentEmail)
				.mobile(agentMobile)
				.additionalFields(parameterMap)
				.build();
		
		producer.sendEmailSmsNotification(notificationDTO);
	}

}
