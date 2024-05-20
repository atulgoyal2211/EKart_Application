package com.company.ekart.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.ekart.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
