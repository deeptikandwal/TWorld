package com.travel.world.Tworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.world.Tworld.documents.Customer;
import com.travel.world.Tworld.dto.CustomerDto;
import com.travel.world.Tworld.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(@Autowired CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public List<Customer> getCustomers() {
        return customerService.findAllCustomers();
    }

    @PostMapping("/create")
    public Customer createUser(@RequestBody CustomerDto customerDto) {
        return customerService.saveCustomer(customerDto);
    }
}