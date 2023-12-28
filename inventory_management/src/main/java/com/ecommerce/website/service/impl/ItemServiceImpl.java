package com.ecommerce.website.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.website.constant.ApiConstant;
import com.ecommerce.website.constant.ResponseCodeConstant;
import com.ecommerce.website.constant.ResponseConstant;
import com.ecommerce.website.dto.CustomerDTO;
import com.ecommerce.website.dto.ItemDTO;
import com.ecommerce.website.dto.ResponseDTO;
import com.ecommerce.website.dto.ResponseDTOBuilder;
import com.ecommerce.website.grpc.CustomerRegisterServiceGrpc;
import com.ecommerce.website.grpc.Customer.CustomerRegister;
import com.ecommerce.website.grpc.Customer.CustomerRegisterResponse;
import com.ecommerce.website.grpc.Customer.CustomerRequest;
import com.ecommerce.website.grpc.CustomerRegisterServiceGrpc.CustomerRegisterServiceBlockingStub;
import com.ecommerce.website.models.Item;
import com.ecommerce.website.repository.ItemRepository;
import com.ecommerce.website.service.ItemService;
import com.ecommerce.website.service.NotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemRepository itemRepository;
	
	ModelMapper modelMapper=new ModelMapper();
	ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private ResponseDTOBuilder responseDTOBuilder;
	
	@Autowired
	private NotificationService notificationService;
	@Override
	public ResponseDTO addItem(ItemDTO itemDTO) {
		Item item=modelMapper.map(itemDTO, Item.class);
		Item saveItem=itemRepository.save(item);
		String api = ApiConstant.ADD_ITEM;

		ResponseDTO responseDTO = findByMobile(itemDTO.getAgentMobile());
		CustomerDTO customerDTO = objectMapper.convertValue(responseDTO.getData(), CustomerDTO.class);
		log.info("the value of the customerDTO : {}",customerDTO);
		sendNotification(api,itemDTO.getAgentEmail(),itemDTO.getAgentMobile(),customerDTO);
		log.info("notification send successfully");
		return responseDTOBuilder.build(ResponseCodeConstant.SUCCESS_CODE, saveItem);
	}

	@Override
	public ResponseDTO updateItem(Long id, ItemDTO itemDTO) {
		try {
			log.info("the requested Id : {} ",id);
			Optional<Item> optional=itemRepository.findById(id);
			if(optional.isPresent()) {
				Item item = updateItem(optional, itemDTO);
				Item updatedItem=itemRepository.save(item);
				return responseDTOBuilder.build(ResponseCodeConstant.SUCCESS_CODE,updatedItem);
			}
			return responseDTOBuilder.build(ResponseCodeConstant.FAILURE_CODE,"Given Id is not present in table");
		} catch (Exception e) {
			log.info("Exception occurs while updating item : {} : {}",e,e.getMessage());
			return responseDTOBuilder.build(ResponseCodeConstant.EXCEPTION_CODE);
		}
	}

	private Item updateItem(Optional<Item> optional, ItemDTO itemDTO) {
		Item item = optional.get();
		item.setCategory(itemDTO.getCategory());
		item.setDiscount(itemDTO.getDiscount());
		item.setPrice(itemDTO.getPrice());
		item.setRating(itemDTO.getRating());
		item.setSubCategory(itemDTO.getSubCategory());
		return item;
	}

	@Override
	public ResponseDTO viewItems() {
		try {
			List<Item> itemList = itemRepository.findAll();
			return responseDTOBuilder.build(ResponseCodeConstant.SUCCESS_CODE,itemList);
		} catch (Exception e) {
			log.info("Exception occurs while view items : {} : {}",e,e.getMessage());
			return responseDTOBuilder.build(ResponseCodeConstant.EXCEPTION_CODE);
		}
	}

	@Override
	public ResponseDTO findBySubCategory(String subCategory) {
		try {
			List<Item> itemList = itemRepository.findBySubCategoryIgnoreCase(subCategory);
			if(!itemList.isEmpty())
				return responseDTOBuilder.build(ResponseCodeConstant.SUCCESS_CODE,itemList);
			else {
				log.info(ResponseConstant.NOT_DATA_FOUND,subCategory);
				return responseDTOBuilder.build(ResponseCodeConstant.NOT_FOUND,ResponseConstant.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			log.info("Exception occurs while find by subCategory  : {} : {}",e,e.getMessage());
			return responseDTOBuilder.build(ResponseCodeConstant.EXCEPTION_CODE);
		}
	}

	private void sendNotification(String api, String agentEmail, String agentMobile,CustomerDTO customerDTO) {
		
		Map<String, Object> parameterMap = new HashMap<>();
		if(api.contains("add")) {
			notificationService.prepareAndSendNotification(agentEmail,agentMobile,parameterMap);
		}
	}

	@Override
	public ResponseDTO findByMobile(String mobile) {
		try {
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
					.usePlaintext()
					.build();
			CustomerRegisterServiceBlockingStub customer = CustomerRegisterServiceGrpc.newBlockingStub(channel);
			CustomerRequest customerRequest = CustomerRequest.newBuilder()
					.setMobile(Long.parseLong(mobile))
					.build();
			
			CustomerRegisterResponse response = customer.fetchCustomers(customerRequest);
			channel.shutdown();
			log.info("the response we get from the account registration service : {}",response);
			
			CustomerDTO customerDTO = responseToDTO(response);
			log.info("the customerDTO value : {} from account registration service ",customerDTO);
			return responseDTOBuilder.build(ResponseCodeConstant.SUCCESS_CODE,customerDTO);
		} catch (Exception e) {
			log.info("Exception occurs while find by subCategory  : {} : {}",e,e.getMessage());
			return responseDTOBuilder.build(ResponseCodeConstant.EXCEPTION_CODE);
		}
	}

	private CustomerDTO responseToDTO(CustomerRegisterResponse response) {
		CustomerRegister register = response.getCustomerRegister(0);
		return CustomerDTO.builder()
				.firstName(register.getFirstName())
				.lastName(register.getLastName())
				.email(register.getEmail())
				.mobile(register.getMobile())
				.password(register.getPassword())
				.build();
	}
}
