package com.pluralsight.NorthwindTradersSpringBoot.repository;

import com.pluralsight.NorthwindTradersSpringBoot.models.Category;
import com.pluralsight.NorthwindTradersSpringBoot.models.Product;

import java.util.List;

public interface CategoryDAO {

    void add(Category c);

    void delete(int categoryId);

    Category getById(int id);

    List<Category> getAll();
}
