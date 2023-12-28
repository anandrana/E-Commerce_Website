package com.ecommerce.website.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.ecommerce.website.enums.Categories;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDTO {
	
	@Enumerated(EnumType.STRING)
	@JsonProperty("category")
	private Categories category;
	
	@JsonProperty("subCategory")
	private String subCategory;
	
	@JsonProperty("rating")
	private Integer rating;
	
	@JsonProperty("price")
	private Long price;
	
	@JsonProperty("discount")
	private Long discount;
	
	@JsonProperty("agentMobile")
	private String agentMobile;
	
	@JsonProperty("agentEmail")
	private String agentEmail;
	// adding offer and add coupoun in farther business logic
}
