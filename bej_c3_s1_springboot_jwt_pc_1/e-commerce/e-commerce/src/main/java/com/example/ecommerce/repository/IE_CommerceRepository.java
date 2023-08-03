package com.example.ecommerce.repository;

import com.example.ecommerce.domain.Customer;
import com.example.ecommerce.domain.E_Commerce;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IE_CommerceRepository extends MongoRepository<Customer, Integer> {
}
