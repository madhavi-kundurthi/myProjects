package com.example.demo.dto;

import com.example.demo.model.Customer;
import lombok.Data;

import java.util.List;

@Data
public class ResponseDetails {
    List<Customer> customerDetails;

    private  int totalPages;
    private long totalElements;
    private int currentPage;
}
