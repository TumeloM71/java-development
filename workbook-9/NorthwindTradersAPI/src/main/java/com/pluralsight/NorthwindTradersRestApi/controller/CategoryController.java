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
        categoryDAO.add(category);
        return category;
    }

    @DeleteMapping("/categories/delete/{id}")
    public int delete(@PathVariable("id") int id){
        categoryDAO.delete(id);
        return 0;
    }

    @PutMapping("/categories/updatename/id/{id}/name/{name}")
    public int updateName(@PathVariable("id") int id, @PathVariable("name") String name){
        System.out.println("In update");
        categoryDAO.updateName(id, name);
        System.out.println("After update");
        return 0;
    }
}
