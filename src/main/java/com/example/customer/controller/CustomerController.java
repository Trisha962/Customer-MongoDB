package com.example.customer.controller;

import com.example.customer.domain.Customer;
import com.example.customer.exception.CustomerAlreadyExists;
import com.example.customer.exception.CustomerNotFound;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;
import com.example.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    //http://localhost:1011/api/Customer/v1/addCustomer  [post] json
    @PostMapping("/addCustomer")
    public ResponseEntity addEmployee(@RequestBody Customer customer) throws CustomerAlreadyExists {
        try {
            return new ResponseEntity(customerService.addCustomer(customer), HttpStatus.CREATED);
        } catch (CustomerAlreadyExists exception) {
            throw exception;
        }
    }

    // http://localhost:1011/api/Customer/v1/getCustomer
    @GetMapping("/getCustomer")
    public ResponseEntity<?> getEmployee() {
        return new ResponseEntity(customerService.getCustomer(), HttpStatus.OK);
    }

    //  http://localhost:1011/api/Customer/v1/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) throws CustomerNotFound {
        if (customerService.deleteById(id)) {
            return new ResponseEntity<>("Deleted Successfully !! ", HttpStatus.OK);
        } else
            throw new CustomerNotFound();
    }

    //http://localhost:1011/api/Customer/v1/getCustomerById/{id}
    @GetMapping("/getCustomerById/{id}")
    public ResponseEntity getCustomerById(@PathVariable Integer id) throws CustomerNotFound {
        return new ResponseEntity(customerService.getCustomerById(id), HttpStatus.OK);
    }

    //http://localhost:1011/api/Customer/v1/updateCustomer/{id}
    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity updateCustomer(@RequestBody Customer customer, @PathVariable Integer id) throws CustomerNotFound {
        return new ResponseEntity(customerService.updateCustomer(customer, id), HttpStatus.CREATED);
    }


    //  http://localhost:1011/api/Customer/v1/getByProductName/{productName}
    @GetMapping("/getByProductName/{productName},{productName2}")
    public ResponseEntity getByProductName(@PathVariable String productName, @PathVariable String productName2) {
        return new ResponseEntity(customerService.getCustomerByProductName(productName, productName2), HttpStatus.OK);
    }
}


