package com.pluralsight;
import java.sql.*;

public class Northwind {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection;
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind",
                "root",
                "yearup");

        Statement statement = connection.createStatement();
        String query = "SELECT ProductName, CategoryName FROM northwind.products p " +
                "JOIN northwind.categories c on  p.CategoryID = c.CategoryID";

        ResultSet results = statement.executeQuery(query);

        for (int i = 1; i<= results.getMetaData().getColumnCount(); i++) {
            System.out.print(results.getMetaData().getColumnLabel(i)+ "|");
        }
        System.out.println();
        while (results.next()) {
            for (int i = 1; i<= results.getMetaData().getColumnCount(); i++) {
                System.out.print(results.getString(i)+", ");
            }
            System.out.println();
        }
        connection.close();

    }
}
