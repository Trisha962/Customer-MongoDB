package com.example.customer.service;

import com.example.customer.domain.Customer;
import com.example.customer.exception.CustomerAlreadyExists;
import com.example.customer.exception.CustomerNotFound;
import com.example.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{

    CustomerRepository iCustomerrepository;

    @Autowired
    public CustomerService(CustomerRepository iCustomerrepository) {
        this.iCustomerrepository = iCustomerrepository;
    }


    @Override
    public Customer addCustomer(Customer customer) throws CustomerAlreadyExists{
        if(iCustomerrepository.findById(customer.getCustomerId()).isEmpty()){
            return iCustomerrepository.insert(customer);
        }
        throw new CustomerAlreadyExists();
    }

    @Override
    public List<Customer> getCustomer() {
        return iCustomerrepository.findAll();
    }

    @Override
    public Customer getCustomerById(int id) throws CustomerNotFound {
        if(iCustomerrepository.findById(id).isEmpty())
        {
            throw new CustomerNotFound();
        }
        else {
            return iCustomerrepository.findById(id).get();
        }
    }

    @Override
    public Customer updateCustomer(Customer customer, int id) throws CustomerNotFound {
        if(iCustomerrepository.findById(id).isEmpty())
        {
            throw new CustomerNotFound();
        }
        else
        {
            return iCustomerrepository.save(customer);
        }
    }

    @Override
    public boolean deleteById(Integer id) throws CustomerNotFound {
        // Customer ids= iCustomerrepository.findById(customer.getCustomerId()).get();
        if (iCustomerrepository.findById(id).isEmpty()){
            throw new  CustomerNotFound();
        }
        else
            iCustomerrepository.deleteById(id);
        return true;
    }

    @Override
    public List<Customer> getCustomerByProductName(String prod_name, String prod_name2) {
        return iCustomerrepository.getCustomerByproductName(prod_name, prod_name2);
    }
}
