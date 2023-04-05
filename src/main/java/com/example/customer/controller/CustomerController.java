package com.example.customer.controller;

import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

   @GetMapping("getPhone/Samsung")
    public ResponseEntity<?> getSamsung(String samsung){
      return new ResponseEntity<>(customerRepository.findBySamsung(samsung), HttpStatus.OK);
  }

}
