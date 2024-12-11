package com.pluralsight.NorthwindTradersSpringBoot.controller;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import com.pluralsight.NorthwindTradersSpringBoot.repository.ProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.repository.ProductDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/products/")
    public List<Product> getAll(){
        return productDAO.getAll();
    }

    @GetMapping("/products/{id}")
    public Product getById(@PathVariable int id){
        return productDAO.getById(id);
    }
}
