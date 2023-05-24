package com.ty.springbootsecurity30.controller;

import com.ty.springbootsecurity30.dto.Product;
import com.ty.springbootsecurity30.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/welcome")
    public String welcome(){

        return "Welcome this endpoint is not secure";
    }
    
    

    @GetMapping("/getAll")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){

        return productService.getProductById(id);
    }

}
