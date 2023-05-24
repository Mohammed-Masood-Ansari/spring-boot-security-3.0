package com.ty.springbootsecurity30.repository;

import com.ty.springbootsecurity30.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
