package com.pluralsight.datamanagers;

import com.pluralsight.models.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiclesDAO {

    private String userName;
    private String password;
    private BasicDataSource dataSource;

    public VehiclesDAO(String userName, String password) {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/car dealerships");
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        this.userName = userName;
        this.password = password;
    }

    public void addVehicle(Vehicle vehicle){

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("""
                    INSERT INTO `car dealerships`.vehicles
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                    """, Statement.RETURN_GENERATED_KEYS)){

            statement.setString(1, vehicle.VIN());
            statement.setString(2, vehicle.make());
            statement.setString(3, vehicle.model());
            statement.setInt(4, vehicle.year());
            statement.setInt(5,vehicle.mileage());
            statement.setDouble(6,vehicle.price());
            statement.setInt(7,vehicle.sold());
            statement.setString(8,vehicle.color());
            statement.setString(9,vehicle.type());

            int rows = statement.executeUpdate();
            System.out.println("Rows added: "+rows);
            this.displayAddedKeys(statement);

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteVehicle(String VIN){
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("""
                      DELETE FROM `car dealerships`.vehicles
                      WHERE VIN = ?
                      """)
        ) {
            statement.setString(1, VIN);
            int rows = statement.executeUpdate();
            System.out.println("Rows deleted: "+rows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayAddedKeys(PreparedStatement statement){

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

    public List<Vehicle> getByPriceRange(double minPrice, double maxPrice){
        List<Vehicle> output;
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(""" 
                        SELECT * FROM `car dealerships`.vehicles
                        WHERE Price BETWEEN ? AND ?   
                        """)
            ){
                statement.setDouble(1,minPrice);
                statement.setDouble(2, maxPrice);
                output = getVehiclesList(statement);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }

    public List<Vehicle> getByYearRange(int minYear, int maxYear){
        List<Vehicle> output;
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(""" 
                        SELECT * FROM `car dealerships`.vehicles
                        WHERE Year BETWEEN ? AND ?   
                        """)
        ){
            statement.setInt(1,minYear);
            statement.setInt(2,maxYear);
            output = getVehiclesList(statement);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }

    public List<Vehicle> getByMakeModel(String make, String model){
        List<Vehicle> output;
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(""" 
                        SELECT * FROM `car dealerships`.vehicles
                        WHERE Make LIKE ? AND Model LIKE ?   
                        """)
        ){
            statement.setString(1,'%'+make+'%');
            statement.setString(2,'%'+model+'%');
            output = getVehiclesList(statement);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }

    public List<Vehicle> getByMake(String make){
        List<Vehicle> output;
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(""" 
                        SELECT * FROM `car dealerships`.vehicles
                        WHERE Make LIKE ? 
                        """)
        ){
            statement.setString(1,'%'+make+'%');
            output = getVehiclesList(statement);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }

    public List<Vehicle> getByMileageRange(int min, int max){
        List<Vehicle> output;
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(""" 
                        SELECT * FROM `car dealerships`.vehicles
                        WHERE Mileage BETWEEN ? AND ?   
                        """)
        ){
            statement.setInt(1,min);
            statement.setInt(2,max);
            output = getVehiclesList(statement);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }

    public List<Vehicle> getByColor(String color){
        List<Vehicle> output;
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(""" 
                        SELECT * FROM `car dealerships`.vehicles
                        WHERE Color LIKE ? 
                        """)
        ){
            statement.setString(1,'%'+color+'%');
            output = getVehiclesList(statement);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }

    public List<Vehicle> getByType(String type){
        List<Vehicle> output;
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(""" 
                        SELECT * FROM `car dealerships`.vehicles
                        WHERE Type LIKE ? 
                        """)
        ){
            statement.setString(1,'%'+type+'%');
            output = getVehiclesList(statement);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return output;
    }

    public List<Vehicle> getVehiclesList(PreparedStatement statement){
        List<Vehicle> vehicles = new ArrayList<>();

        try(
                ResultSet results = statement.executeQuery();
            ){
                while (results.next()){
                    String vin = results.getString("VIN");
                    String make = results.getString("Make");
                    String model = results.getString("Model");
                    int year = results.getInt("Year");
                    int mileage = results.getInt("Mileage");
                    double price = results.getDouble("Price");
                    int sold = results.getInt("Sold");
                    String color = results.getString("Color");
                    String type = results.getString("Type");

                    vehicles.add(new Vehicle(vin,make,model,year,mileage,price,sold,color,type));
                }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }
}
