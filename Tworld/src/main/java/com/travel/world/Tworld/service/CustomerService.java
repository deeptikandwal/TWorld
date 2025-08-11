package com.travel.world.Tworld.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.world.Tworld.documents.Customer;
import com.travel.world.Tworld.dto.CustomerDto;
import com.travel.world.Tworld.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository customerRepository;
	private ModelMapper modelMapper;

	public CustomerService(@Autowired CustomerRepository customerRepository, @Autowired ModelMapper modelMapper) {
		this.customerRepository = customerRepository;
		this.modelMapper = modelMapper;
	}

	public Customer saveCustomer(CustomerDto customerDto) {
		return customerRepository.save(modelMapper.map(customerDto,Customer.class));
	}
	
	public List<Customer> findAllCustomers(){
		return customerRepository.findAll();
	}

}
