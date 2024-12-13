package com.pluralsight.NorthwindTradersRestApi.controller;

import com.pluralsight.NorthwindTradersRestApi.models.Category;
import com.pluralsight.NorthwindTradersRestApi.repository.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryDAO categoryDAO;

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return categoryDAO.getAll();
    }

    @GetMapping("/categories/{id}")
    public Category getById(@PathVariable int id){
        return categoryDAO.getById(id);
    }

    @PostMapping("/categories/add")
    public Category add(@RequestBody Category category){
        int key = categoryDAO.add(category);
        return categoryDAO.getById(key);
    }

    @DeleteMapping("/categories/delete/{id}")
    public void delete(@PathVariable("id") int id){
        categoryDAO.delete(id);
    }

    @PutMapping("/categories/update/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Category category){
        categoryDAO.update(id, category);
    }
}
