package com.ecommerce.website.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ecommerce.website.enums.Categories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "items")
public class Item implements Serializable{

	private static final long serialVersionUID = 98380499620655L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence",sequenceName = "itemId_seq",allocationSize = 1)
	@Column(name = "item_Id")
	private Long itemId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "category")
	private Categories category;
	
	@Column(name = "sub_category")
	private String subCategory;
	
	@Column(name = "rating")
	private Integer rating;
	
	@Column(name = "price")
	private Long price;
	
	@Column(name="discount")
	private Long discount;
	
	@Column(name="agent_mobile")
	private String agentMobile;
	
	@Column(name="agent_email")
	private String agentEmail;
	// adding offer and add coupoun in farther business logic
}
