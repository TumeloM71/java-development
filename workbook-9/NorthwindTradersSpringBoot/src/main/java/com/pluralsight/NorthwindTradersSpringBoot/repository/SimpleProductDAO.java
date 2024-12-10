package com.pluralsight.NorthwindTradersSpringBoot.repository;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;

import java.util.List;

public interface SimpleProductDAO {

    void add(Product p);

    List<Product> getAll();
}
