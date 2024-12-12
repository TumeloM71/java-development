package com.pluralsight.NorthwindTradersRestApi.repository;

import com.pluralsight.NorthwindTradersRestApi.models.Product;

import java.util.List;

public interface ProductDAO {

    void add(Product p);

    void delete(int productId);

    Product getById(int id);

    List<Product> getAll();
}
