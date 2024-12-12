package com.pluralsight.NorthwindTradersRestApi.controller;

import com.pluralsight.NorthwindTradersRestApi.models.Product;
import com.pluralsight.NorthwindTradersRestApi.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/products")
    public List<Product> getAll(){
        return productDAO.getAll();
    }

    @GetMapping("/products/{id}")
    public Product getById(@PathVariable("id") int id){
        return productDAO.getById(id);
    }

    @PostMapping("/products/add")
    public Product addProduct (@RequestBody Product product){
        productDAO.add(product);
        return product;
    }

    @DeleteMapping("/products/delete/{id}")
    public int delete(@PathVariable("id") int id){
        productDAO.delete(id);
        return 0;
    }

    @PutMapping("/products/updatename/id/{id}/name/{name}")
    public int updateName(@PathVariable("id") int id, @PathVariable("name") String name){
        productDAO.updateName(id, name);
        return 0;
    }
}
