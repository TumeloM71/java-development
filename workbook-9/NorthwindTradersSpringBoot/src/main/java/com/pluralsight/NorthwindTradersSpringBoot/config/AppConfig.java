package com.pluralsight.NorthwindTradersSpringBoot.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class AppConfig {

    @Bean
    public DataSource getDataSource (@Value("${datasource.url}") String url,
                                  @Value("${datasource.username}") String username,
                                  @Value("${datasource.password}") String password){
        BasicDataSource basicDataSource;
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }


    @Bean
    public String selectAllStatement(){
        return """
                USE northwind;
                SELECT ProductID, ProductName, CategoryName, UnitPrice FROM products p
                JOIN categories c ON p.CategoryID = c.CategoryId;
                """;
    }

}
