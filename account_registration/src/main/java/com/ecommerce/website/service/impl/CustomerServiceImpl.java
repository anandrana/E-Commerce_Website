package com.ecommerce.website.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.website.constant.ResponseCodeConstant;
import com.ecommerce.website.dto.CustomerDTO;
import com.ecommerce.website.dto.LoginDTO;
import com.ecommerce.website.dto.ResponseDTO;
import com.ecommerce.website.dto.ResponseDTOBuilder;
import com.ecommerce.website.models.CustomerRegister;
import com.ecommerce.website.repository.CustomerRepository;
import com.ecommerce.website.service.CustomerService;
import com.ecommerce.website.utils.DateUtility;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ResponseDTOBuilder responseDTOBuilder;
	
	ModelMapper modelMapper = new ModelMapper();
	@Override
	public ResponseDTO signUp(CustomerDTO customerDTO) {
		try {
			log.info("checking if userName is already exist : {}",customerDTO.getEmail());
			CustomerRegister customer = customerRepository.findFirstByEmail(customerDTO.getEmail());
			if(null != customer) {
				log.info("userName is already Exist");
				return responseDTOBuilder.build(ResponseCodeConstant.FAILURE_CODE,"userName is already Exist");
			}
					
			CustomerRegister customerRegister = modelMapper.map(customerDTO, CustomerRegister.class);
			customerRegister.setCreationTimestamp(DateUtility.localToTimeStamp());
			CustomerRegister saveCustomer=customerRepository.save(customerRegister);
			log.info("the saveCustomer value : {}",saveCustomer);
			return responseDTOBuilder.build(ResponseCodeConstant.SUCCESS_CODE, saveCustomer);	
		} catch (Exception e) {
			log.info("Exception occurs while login the customer");
			return responseDTOBuilder.build(ResponseCodeConstant.EXCEPTION_CODE, e.getMessage());
		}
	}
	
	@Override
	public ResponseDTO login(LoginDTO loginDTO) {
		try {
			
			String password = loginDTO.getPassword();
			CustomerRegister customerRegister = customerRepository.findFirstByEmail(loginDTO.getUserName());
			if(null == customerRegister) {
				log.info("customer is not present for given userName");
				return responseDTOBuilder.build(ResponseCodeConstant.NOT_FOUND,"Customer is Not Found");
			}else {
				if(customerRegister.getPassword().equals(password)) {
					log.info("successfully login ");
					return responseDTOBuilder.build(ResponseCodeConstant.SUCCESS_CODE, customerRegister);
				}else {
					log.info("password is wrong please enter correct password");
					return responseDTOBuilder.build(ResponseCodeConstant.FAILURE_CODE,"password is wrong");
				}
			}
		} catch (Exception e) {
			log.info("Exception occurs while login the customer");
			return responseDTOBuilder.build(ResponseCodeConstant.EXCEPTION_CODE, e.getMessage());
		}
	}

	@Override
	public ResponseDTO findByMobile(String mobile) {

		List<CustomerRegister> customerList = customerRepository.findByMobile(mobile);
		return responseDTOBuilder.build(ResponseCodeConstant.SUCCESS_CODE,customerList);
	}

}
