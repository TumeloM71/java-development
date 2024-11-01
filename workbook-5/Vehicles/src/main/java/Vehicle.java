public class Vehicle {

    private String name;
    private String color;
    private double topSpeed;
    private double accelerationRate;  // m/hr/s
    private int mass; //In kg
    private int numberOfPassengers;
    private int cargoCapacity;
    private int fuelCapacity;

    public Vehicle(String name, String color, double topSpeed, double accelerationRate, int mass, int numberOfPassengers, int cargoCapacity, int fuelCapacity) {
        this.name = name;
        this.color = color;
        this.topSpeed = topSpeed;
        this.accelerationRate = accelerationRate;
        this.mass = mass;
        this.numberOfPassengers = numberOfPassengers;
        this.cargoCapacity = cargoCapacity;
        this.fuelCapacity = fuelCapacity;
    }

    public Vehicle(){}

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getAccelerationRate() {
        return accelerationRate;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMass() {
        return mass;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    public void setAccelerationRate(double accelerationRate) {
        this.accelerationRate = accelerationRate;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }
}
