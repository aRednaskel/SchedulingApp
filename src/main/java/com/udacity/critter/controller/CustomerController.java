package com.udacity.critter.controller;

import com.udacity.critter.dto.CustomerDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/customer")
public class CustomerController {
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        return null;
    }

    public List<CustomerDTO> getAllCustomers() {
        return null;
    }
}
