package com.example.customer.repository;

import com.example.customer.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer,Integer> {
    public List<Customer> findBySamsung(String samsung);

    List<Customer> getAllCustomer(String customerName);
}
