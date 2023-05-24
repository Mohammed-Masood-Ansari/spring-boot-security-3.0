package com.ty.springbootsecurity30.dao;

import com.ty.springbootsecurity30.dto.Product;
import com.ty.springbootsecurity30.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * database code
 */
@Repository
public class ProductDao {

    @Autowired
    private ProductRepository productRepository;

    /**
       saveMethod
     */
    public Product saveProduct(Product product){

        return productRepository.save(product);
    }
    
    /*
     * getProductDetails by passing single productId
     */
    public Product getProductById(int productId) {
    	
    	Optional<Product> optional = productRepository.findById(productId);
    	
    	if(optional.isPresent()) {
    		
    		return optional.get();
    	}else {
    		return null;
    	}
    }
    
    /*
     * getAllProductDetails
     */
    public List<Product> getAllProducts(){
    	
    	return productRepository.findAll();
    }

}
