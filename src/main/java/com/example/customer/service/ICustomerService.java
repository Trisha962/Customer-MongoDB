package com.example.customer.service;

import com.example.customer.domain.Customer;
import com.example.customer.exception.CustomerAlreadyExists;
import com.example.customer.exception.CustomerNotFound;

import java.util.List;

public interface ICustomerService {
    public Customer addCustomer(Customer customer) throws CustomerAlreadyExists;
    public boolean deleteCustomer(int id) throws CustomerNotFound;
    public List<Customer> getCustBySamsung(String customerName)  throws CustomerAlreadyExists ;
    public List<Customer> getAllCustomer(String customerName)  throws CustomerAlreadyExists;
}
