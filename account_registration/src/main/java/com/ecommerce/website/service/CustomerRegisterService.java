package com.ecommerce.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.website.grpc.Customer;
import com.ecommerce.website.grpc.Customer.CustomerRegisterResponse;
import com.ecommerce.website.grpc.Customer.CustomerRequest;
import com.ecommerce.website.grpc.CustomerRegisterServiceGrpc.CustomerRegisterServiceImplBase;
import com.ecommerce.website.models.CustomerRegister;
import com.ecommerce.website.repository.CustomerRepository;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerRegisterService extends CustomerRegisterServiceImplBase{

    @Autowired
    private CustomerRepository customerRepository;
	@Override
	public void fetchCustomers(CustomerRequest request, StreamObserver<CustomerRegisterResponse> responseObserver) {
		
        log.info("inside the fetchCustomers");
        Long mobile=request.getMobile();
        log.info("the mobile value : {}",mobile);
        List<CustomerRegister> customerList = customerRepository.findByMobile(mobile.toString());

        CustomerRegisterResponse.Builder response = CustomerRegisterResponse.newBuilder();

        log.info("the customerList : {}",customerList);

        for(CustomerRegister customerRegister : customerList){
            response.addCustomerRegister(Customer.CustomerRegister.newBuilder()
                                        .setCustomerId(customerRegister.getCustomerId())
                                        .setFirstName(customerRegister.getFirstName())
                                        .setLastName(customerRegister.getLastName())
                                        .setEmail(customerRegister.getEmail())
                                        .setMobile(customerRegister.getMobile())
                                        .setPassword(customerRegister.getPassword())
                                        .build());
        }

        log.info("the response of student list : {} ",response);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
	}
    
}
