package com.example.ecommerce.service;

import com.example.ecommerce.domain.Customer;
import com.example.ecommerce.repository.IE_CommerceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class E_CommerceService implements IE_CommerceService{
    @Autowired
    IE_CommerceRepository ieCommerceRepository;
    @Override
    public Customer saveDetails(Customer customer) {
        return ieCommerceRepository.save(customer);
    }

    @Override
    public Customer getCustomers(int customerId) {
        return ieCommerceRepository.findById(customerId).get();
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        if(ieCommerceRepository.findById(customerId).isPresent())
        {
            ieCommerceRepository.deleteById(customerId);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public List<Customer> getAllUsersByAdmin() {
        return ieCommerceRepository.findAll();
    }
}
