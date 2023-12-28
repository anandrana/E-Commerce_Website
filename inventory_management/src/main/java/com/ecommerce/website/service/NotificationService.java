package com.ecommerce.website.service;

import java.util.Map;

public interface NotificationService {

	void prepareAndSendNotification(String agentEmail, String agentMobile, Map<String, Object> parameterMap);

	
}
