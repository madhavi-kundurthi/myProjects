package com.example.demo.controller;

import com.example.demo.dto.ResponseDetails;
import com.example.demo.model.Customer;
import com.example.demo.model.Department;
import com.example.demo.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @InjectMocks
    CustomerController customerController;

    @Mock
    CustomerService customerService;

       @Test
    public void test_getCustomerDetails_success() throws Exception {

        Customer customerDetails = new Customer();
        Department department = new Department();
        department.setDepartmentName("HR");
        department.setId(1);
        List<Department> departmentList = new ArrayList<>();
        departmentList.add(department);
        customerDetails.setFirstName("test");
        customerDetails.setLastName("lname");
        customerDetails.setPhoneNumber(1234567890);
        customerDetails.setId(101);
        customerDetails.setDepartment(departmentList);
        ArrayList<Customer> customerDetails1 = new ArrayList<>();
        ResponseDetails responseDetails = new ResponseDetails() ;
        responseDetails.setCustomerDetails(customerDetails1);
        customerDetails1.add(customerDetails);

        Mockito.when(customerService.getAllCustomerDetails()).thenReturn(responseDetails);
        ResponseDetails responseDetails1 = customerService.getAllCustomerDetails();

        assertEquals(responseDetails1.getCustomerDetails().get(0).getId(),101);

    }
}
