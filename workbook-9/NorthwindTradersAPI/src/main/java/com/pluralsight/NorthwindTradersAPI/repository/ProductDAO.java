package com.pluralsight.NorthwindTradersAPI.repository;

import com.pluralsight.NorthwindTradersAPI.model.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Products, Integer> {
}
