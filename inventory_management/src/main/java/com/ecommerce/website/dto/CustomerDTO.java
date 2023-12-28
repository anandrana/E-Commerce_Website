package com.ecommerce.website.dto;

import javax.persistence.Embedded;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
	
	private String firstName;
	private String lastName;

	@javax.validation.constraints.NotEmpty
	private String email;
	private String mobile;

	@NotEmpty
	private String password;
}
