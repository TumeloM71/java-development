package com.pluralsight;
import java.sql.*;

public class Northwind_Exercise2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String userName = args[0];
        String password = args[1];

        Connection connection;
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind",
                userName,
                password);

        PreparedStatement statement = connection.prepareStatement("SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM northwind.products");

        ResultSet results = statement.executeQuery();

        while (results.next()) {
            for (int i = 1; i<= results.getMetaData().getColumnCount(); i++) {
                System.out.print(results.getMetaData().getColumnLabel(i)+" : ");
                System.out.print(results.getString(i)+"\n");
            }
            System.out.println("---".repeat(80));
        }
        results.close();
        statement.close();
        connection.close();

    }
}
