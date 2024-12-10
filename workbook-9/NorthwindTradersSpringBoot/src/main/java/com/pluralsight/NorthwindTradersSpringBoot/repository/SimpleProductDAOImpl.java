package com.pluralsight.NorthwindTradersSpringBoot.repository;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDAOImpl implements SimpleProductDAO {

    private List<Product> products;

    public SimpleProductDAOImpl() {
        products = new ArrayList<>();
        products.add(new Product(1,"Oreo Cookies","Snacks",2.89));
        products.add(new Product(2,"Cheetos","Snacks",3.78));
        products.add(new Product(3,"Sour Patch Kids","Snacks",2.06));
    }

    @Override
    public void add(Product p){
        products.add(p);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }


}
