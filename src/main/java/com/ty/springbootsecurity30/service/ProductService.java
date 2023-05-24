package com.ty.springbootsecurity30.service;

import com.ty.springbootsecurity30.dao.ProductDao;
import com.ty.springbootsecurity30.dto.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {


    @Autowired
    private ProductDao  productDao;
    public Product saveProduct(Product product){

        return productDao.saveProduct(product);

    }
    
    /*
     * getProductDetails by passing single productId
     */
    public Product getProductById(int productId) {
    	return productDao.getProductById(productId);
    }
    
    /*
     * getAllProductDetails
     */
    public List<Product> getAllProducts(){
    	
    	return productDao.getAllProducts();
    }
}
