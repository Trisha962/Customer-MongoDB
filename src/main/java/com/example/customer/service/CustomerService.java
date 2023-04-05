package com.example.customer.service;

import com.example.customer.domain.Customer;
import com.example.customer.exception.CustomerAlreadyExists;
import com.example.customer.exception.CustomerNotFound;
import com.example.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService implements ICustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) throws CustomerAlreadyExists {
        if(customerRepository.findById(customer.getCustomerId()).isEmpty()){
            return customerRepository.insert(customer);
        }
        else {

            throw new CustomerAlreadyExists();
        }

    }

    @Override
    public boolean deleteCustomer(int id) throws CustomerNotFound {
        if(customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        } else {
            throw new CustomerNotFound();
        }
    }

    @Override
    public List<Customer> getCustBySamsung(String customerName) {
        return customerRepository.findBySamsung(customerName);
    }

    @Override
    public List<Customer> getAllCustomer(String customerName) {
        if(customerName != null && !customerName.isEmpty()) {
            return customerRepository.getAllCustomer(customerName);
        } else {
            return customerRepository.findAll();
        }
    }


}
