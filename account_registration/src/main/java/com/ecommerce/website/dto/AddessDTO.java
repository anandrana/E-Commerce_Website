package com.ecommerce.website.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Embeddable
public class AddessDTO {

	private String town_vill;
	private String street;
	private String pincode;
	private String district;
	private String state;
	
}
