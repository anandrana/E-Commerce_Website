package com.ecommerce.website.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@JsonInclude(value = Include.NON_NULL)
@ToString
public class ResponseDTO {

	private String status;
	private Integer statusCode;
	private Object data;
	private String message;
}
