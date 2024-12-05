package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.Scanner;

public class DataManager {

    static String userName = null;
    static String password = null;
    static Scanner scanner = new Scanner(System.in);
    static BasicDataSource dataSource;

    public static void addShipper(String companyName, String phone){

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO northwind.shippers (CompanyName, Phone) " +
                    "VALUES (?, ?)",Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1,companyName);
            statement.setString(2,phone);

            int rows = statement.executeUpdate();
            System.out.println("Rows updated: "+rows);
            displayAddedKeys(statement);

        }
        catch (SQLException e){
            e.printStackTrace();
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

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        DataManager.scanner = scanner;
    }

    public static BasicDataSource getDataSource() {
        return dataSource;
    }

    public static void setDataSource(BasicDataSource dataSource) {
        DataManager.dataSource = dataSource;
    }
}
