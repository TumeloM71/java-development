package com.pluralsight.NorthwindTradersRestApi.repository;

import com.pluralsight.NorthwindTradersRestApi.models.Category;

import java.util.List;

public interface CategoryDAO {

    void add(Category c);

    void delete(int categoryId);

    void updateName(int id, String name);

    Category getById(int id);

    List<Category> getAll();
}
