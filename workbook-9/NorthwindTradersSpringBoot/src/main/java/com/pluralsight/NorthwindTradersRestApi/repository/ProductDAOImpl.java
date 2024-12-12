package com.pluralsight.NorthwindTradersRestApi.repository;

import com.pluralsight.NorthwindTradersRestApi.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDAOImpl implements ProductDAO {

    private List<Product> products;
    private DataSource dataSource;

    @Autowired
    public ProductDAOImpl(DataSource dataSource) {
        this.products = new ArrayList<>();
        this.dataSource = dataSource;
    }

    @Override
    public void add(Product p){
        String sql = """
                INSERT INTO northwind.productswithcategories (ProductName,CategoryName,UnitPrice)
                VALUES(?, ?, ?)
                """;

        try (
              Connection connection = dataSource.getConnection();
              PreparedStatement statement = connection.prepareStatement(sql)
                )
        {
            statement.setString(1,p.getName());
            statement.setString(2,p.getCategory());
            statement.setDouble(3,p.getPrice());

            int rows = statement.executeUpdate();
            System.out.println("Rows updated "+rows);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateName(int productId){

        try( Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("""
                        UPDATE ProductName WHERE ProductId = ?
                        """))
        {
            statement.setInt(1,productId);
            int rows = statement.executeUpdate();
            System.out.println("Rows updated: "+rows);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void delete(int productId){
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("""
                      DELETE FROM northwind.productswithcategories
                      WHERE ProductId = ?
                      """)
        ) {
            statement.setInt(1, productId);
            int rows = statement.executeUpdate();
            System.out.println("Rows deleted: "+rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Product> getAll() {

        this.products.clear();
        String selectAllQuery =  """
      
                SELECT ProductID, ProductName, CategoryName, UnitPrice FROM northwind.productswithcategories p
                ORDER BY p.ProductId;
                """;
        try(
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(selectAllQuery);
            ResultSet resultSet = statement.executeQuery();
                )
        {
            while (resultSet.next()){
                products.add(new Product(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),resultSet.getDouble(4)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return this.products;
    }
    @Override
    public Product getById(int id){

        Product p = new Product();
        String sql = """
                SELECT ProductID, ProductName, CategoryName, UnitPrice FROM northwind.productswithcategories p
                WHERE ProductID = ?
                """;
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        )
        {
            statement.setInt(1,id);

            try (ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next())
                    p = new Product(resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getDouble(4));
            }
            catch (SQLException e){
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

}
