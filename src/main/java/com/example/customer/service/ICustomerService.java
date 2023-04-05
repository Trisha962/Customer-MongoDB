package com.example.customer.service;

import com.example.customer.domain.Customer;
import com.example.customer.exception.CustomerAlreadyExists;
import com.example.customer.exception.CustomerNotFound;

import java.util.List;

public interface ICustomerService {


        public Customer addCustomer(Customer customer) throws CustomerAlreadyExists;

        public List<Customer> getCustomer();

        public Customer getCustomerById(int id) throws CustomerNotFound;

        public Customer updateCustomer(Customer customer, int id) throws CustomerNotFound;

        public boolean deleteById(Integer id) throws CustomerNotFound;

        public List<Customer> getCustomerByProductName(String prod_name, String prod_Name1);
    }

