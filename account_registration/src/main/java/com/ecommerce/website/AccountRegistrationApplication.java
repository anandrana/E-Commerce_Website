package com.ecommerce.website;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ecommerce.website.service.CustomerRegisterService;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class AccountRegistrationApplication {

	@Autowired
	private CustomerRegisterService customerRegisterService;
	public static void main(String[] args) {
		SpringApplication.run(AccountRegistrationApplication.class, args);
	}
	
	@Bean
	public void grpc(){
		log.info("Starting Grpc server....");
		Server server = ServerBuilder.forPort(9091)
				.addService(customerRegisterService).build();
		try{
			server.start();
		}catch (IOException e){
			try {
				server.awaitTermination();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
				log.info("exception occurs");
				Thread.currentThread().interrupt();
			}
			e.printStackTrace();
		}
	}
}
