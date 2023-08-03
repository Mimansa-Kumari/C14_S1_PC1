package com.example.ecommerce.service;

import com.example.ecommerce.domain.Customer;

import java.util.List;

public interface IE_CommerceService {
    Customer saveDetails(Customer customer);
    Customer getCustomers(int customerId);
    boolean deleteCustomer(int customerId);
    List<Customer> getAllUsersByAdmin();
}
