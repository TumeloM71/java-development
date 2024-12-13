package com.pluralsight.NorthwindTradersRestApi.repository;

import com.pluralsight.NorthwindTradersRestApi.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryDAOImpl implements CategoryDAO {

    private List<Category> categories;
    private DataSource dataSource;

    @Autowired
    public CategoryDAOImpl(DataSource dataSource) {
        this.categories = new ArrayList<>();
        this.dataSource = dataSource;
    }

    @Override
    public int add(Category c){
        String sql = """
                INSERT INTO northwind.categories (CategoryName, Description)
                VALUES(?, ?)
                """;
        int key;
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        )
        {
            statement.setString(1,c.getCategoryName());
            statement.setString(2,c.getDescription());

            int rows = statement.executeUpdate();
            System.out.println("Rows updated "+rows);
            key = getAddedKey(statement);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return key;
    }

    public static int getAddedKey(PreparedStatement statement){

        int key = 0;
        try (ResultSet keys = statement.getGeneratedKeys()
        ) {
            while (keys.next()) {
                key = keys.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return key;
    }

    public void update(int categoryId, Category category){

        try( Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("""
                        UPDATE northwind.categories
                        SET CategoryName = ?, Description = ?
                        WHERE CategoryId = ?
                        """))
        {
            statement.setString(1,category.getCategoryName());
            statement.setString(2, category.getDescription());
            statement.setInt(3,categoryId);
            System.out.println("Statement set complete");

            int rows = statement.executeUpdate();
            System.out.println("Rows updated: "+rows);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int categoryId){
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("""
                      DELETE FROM northwind.categories
                      WHERE CategoryId = ?
                      """)
        ) {
            statement.setInt(1, categoryId);
            int rows = statement.executeUpdate();
            System.out.println("Rows deleted: "+rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Category> getAll() {

        this.categories.clear();
        String selectAllQuery =  """
                SELECT CategoryID,CategoryName,Description FROM northwind.categories;
                """;
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(selectAllQuery);
                ResultSet resultSet = statement.executeQuery();
        )
        {
            while (resultSet.next()){
                categories.add(new Category(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return this.categories;
    }
    @Override
    public Category getById(int id){

        Category category = new Category();
        String sql = """
                SELECT CategoryID,CategoryName,Description FROM northwind.categories
                WHERE CategoryID = ?
                """;
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        )
        {
            statement.setInt(1,id);

            try (ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next())
                    category = new Category(resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3));
            }
            catch (SQLException e){
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return category;
    }
}
