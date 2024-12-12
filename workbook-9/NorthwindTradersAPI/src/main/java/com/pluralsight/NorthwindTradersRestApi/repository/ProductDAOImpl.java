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
                INSERT INTO northwind.products (ProductName,CategoryId,UnitPrice)
                VALUES(?, ?, ?)
                """;

        try (
              Connection connection = dataSource.getConnection();
              PreparedStatement statement = connection.prepareStatement(sql)
                )
        {
            statement.setString(1,p.getName());
            statement.setInt(2,p.getCategoryId());
            statement.setDouble(3,p.getPrice());

            int rows = statement.executeUpdate();
            System.out.println("Rows updated "+rows);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int productId, Product product){

        try( Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("""
                        UPDATE northwind.products
                        SET ProductName = ?, CategoryID = ?, UnitPrice = ?
                        WHERE ProductId = ?
                        """))
        {
            statement.setString(1,product.getName());
            statement.setInt(2,product.getCategoryId());
            statement.setDouble(3,product.getPrice());
            statement.setInt(4,productId);

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
                      DELETE FROM northwind.products
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
      
                SELECT ProductID, ProductName, CategoryID, UnitPrice FROM northwind.products p
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
                        resultSet.getInt(3),resultSet.getDouble(4)));
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
                SELECT ProductID, ProductName, CategoryID, UnitPrice FROM northwind.products p
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
                            resultSet.getInt(3), resultSet.getDouble(4));
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
