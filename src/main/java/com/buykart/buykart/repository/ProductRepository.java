package com.buykart.buykart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buykart.buykart.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
