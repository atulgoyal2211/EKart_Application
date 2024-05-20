package com.company.ekart.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.ekart.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
