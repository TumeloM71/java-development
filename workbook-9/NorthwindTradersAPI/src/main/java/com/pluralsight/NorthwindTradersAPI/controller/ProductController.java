package com.pluralsight.NorthwindTradersAPI.controller;

import com.pluralsight.NorthwindTradersAPI.model.Products;
import com.pluralsight.NorthwindTradersAPI.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping(value = "/products")
    public List<Products> getAll(){
        List<Products> output = new ArrayList<>();
         productDAO.findAll().forEach(p -> output.add(p));
         return output;
    }
}
