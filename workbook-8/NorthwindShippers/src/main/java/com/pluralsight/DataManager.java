package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;

public class DataManager {

    static String userName = null;
    static String password = null;
    static BasicDataSource dataSource;

    public static void addShipper(String companyName, String phone){

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO northwind.shippers (CompanyName, Phone) " +
                    "VALUES (?, ?)",Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1,companyName);
            statement.setString(2,phone);

            int rows = statement.executeUpdate();
            System.out.println("Rows added: "+rows);
            displayAddedKeys(statement);

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void updateShipperPhone(int shipperId, String phone){

        try(
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("""
                    UPDATE northwind.shippers
                    SET Phone = ?
                    WHERE ShipperId = ?
                    """)
            ) {
                statement.setString(1, phone);
                statement.setInt(2,shipperId);
                int rows = statement.executeUpdate();
                System.out.println("Rows updated: "+rows);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateShipperName(int shipperId, String name){
        try(
              Connection connection = dataSource.getConnection();
              PreparedStatement statement = connection.prepareStatement("""
                    UPDATE northwind.shippers
                    SET CompanyName = ?
                    WHERE ShipperId = ?
                    """)
            ){
                statement.setString(1,name);
                statement.setInt(2,shipperId);
                int rows = statement.executeUpdate();
                System.out.println("Rows updated: "+rows);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void deleteShipper(int shipperId){
        try(
              Connection connection = dataSource.getConnection();
              PreparedStatement statement = connection.prepareStatement("""
                      DELETE FROM northwind.shippers
                      WHERE ShipperId = ?
                      """)
            ) {
                statement.setInt(1, shipperId);
                int rows = statement.executeUpdate();
            System.out.println("Rows deleted: "+rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void displayShippers(String column, String attribute){

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM northwind.shippers WHERE ? LIKE ?"))
        {
            statement.setString(1,column);
            statement.setString(2,column);
            displayResults(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void displayShippers(){

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM northwind.shippers"))
        {
            displayResults(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void displayAddedKeys(PreparedStatement statement){

        try (ResultSet keys = statement.getGeneratedKeys()
        ) {
            while (keys.next()) {
                System.out.printf("%d key was added\n",
                        keys.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void displayResults(PreparedStatement statement) {
        try (ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                for (int i = 1; i <= results.getMetaData().getColumnCount(); i++) {
                    String columnLabel = results.getMetaData().getColumnLabel(i);
                    String columnVal = results.getString(i);
                    String spaces = " ".repeat(15-columnLabel.length());
                    System.out.print(columnLabel+spaces+": ");
                    System.out.print(columnVal + '\n');
                }
                System.out.println("---".repeat(80));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        DataManager.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DataManager.password = password;
    }


    public static BasicDataSource getDataSource() {
        return dataSource;
    }

    public static void setDataSource(BasicDataSource dataSource) {
        DataManager.dataSource = dataSource;
    }
}
