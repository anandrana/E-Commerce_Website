package com.ecommerce.website.dto;

import org.springframework.stereotype.Component;

import com.ecommerce.website.constant.ResponseCodeConstant;
import com.ecommerce.website.constant.ResponseConstant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Component
public class ResponseDTOBuilder {

	public ResponseDTO build(int statusCode , Object data) {
		
		ResponseDTO responseDTO = ResponseDTO.builder()
				.statusCode(statusCode)
				.message(null)
				.data(data)
				.status(getResponseStatus(statusCode))
				.build();
		return responseDTO;
	}

	public ResponseDTO build(int statusCode) {
		ResponseDTO responseDTO = ResponseDTO.builder()
				.statusCode(statusCode)
				.status(getResponseStatus(statusCode))
				.message(null)
				.build();
		return responseDTO;
	}
	private String getResponseStatus(int statusCode) {
		if(statusCode >= ResponseCodeConstant.SUCCESS_CODE) {
			return ResponseConstant.SUCCESS_STATUS;
		}
		return ResponseConstant.FAILURE_STATUS;
	}
}
