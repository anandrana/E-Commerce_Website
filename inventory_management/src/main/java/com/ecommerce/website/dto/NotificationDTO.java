package com.ecommerce.website.dto;

import java.util.Map;

import com.ecommerce.website.enums.NotificationChannel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationDTO {

	private String mobile;
	private String email;
	private Map<String, Object> additionalFields;
	private NotificationChannel notificationChannel;
}
