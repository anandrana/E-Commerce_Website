package com.ecommerce.website.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.website.models.CustomerRegister;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerRegister, Long>{

	CustomerRegister  findFirstByEmail(String email);

	List<CustomerRegister> findByMobile(String mobile);
}
