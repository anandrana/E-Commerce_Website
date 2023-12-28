package com.ecommerce.website.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.website.constant.ApiConstant;
import com.ecommerce.website.dto.CustomerDTO;
import com.ecommerce.website.dto.LoginDTO;
import com.ecommerce.website.dto.ResponseDTO;
import com.ecommerce.website.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(ApiConstant.API_VERSIONING)
@Slf4j
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@PostMapping(ApiConstant.REGISTER)
	public ResponseDTO signup(@Valid @RequestBody CustomerDTO customerDTO){
		
		log.info("the customerDto request value : {}",customerDTO);
		ResponseDTO responseDTO=customerService.signUp(customerDTO);
		log.info("the responseDTO : {}",responseDTO);
		return responseDTO;
	}
	
	@PostMapping(ApiConstant.LOGIN)
	public ResponseDTO signIn(@Valid @RequestBody LoginDTO loginDTO) {
		log.info("the login requestDTO value : {}",loginDTO);
		ResponseDTO responseDTO=customerService.login(loginDTO);
		return responseDTO;
	}

	@PostMapping("/{mobile}")
	public ResponseDTO findByMobile(@PathVariable String mobile){
		ResponseDTO responseDTO = customerService.findByMobile(mobile);
		return responseDTO;
	}
}
