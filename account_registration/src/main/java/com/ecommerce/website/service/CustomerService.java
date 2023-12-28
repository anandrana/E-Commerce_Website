package com.ecommerce.website.service;

import com.ecommerce.website.dto.CustomerDTO;
import com.ecommerce.website.dto.LoginDTO;
import com.ecommerce.website.dto.ResponseDTO;

public interface CustomerService {

	public ResponseDTO signUp(CustomerDTO customerDTO);

	public ResponseDTO login(LoginDTO loginDTO);

    public ResponseDTO findByMobile(String mobile);
}
