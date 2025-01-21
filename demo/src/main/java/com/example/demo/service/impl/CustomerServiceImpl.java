package com.example.demo.service.impl;

import com.example.demo.dto.ResponseDetails;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public  ResponseDetails getAllCustomerDetails(){
        ResponseDetails responseDetails = new ResponseDetails();
        try {
            List<Customer> customers = customerRepository.findAll();
            responseDetails.setCustomerDetails(customers);
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return responseDetails;
    }
}
