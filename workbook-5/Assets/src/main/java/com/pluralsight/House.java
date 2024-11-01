package com.pluralsight;

public class House extends Asset{

    private String address;
    private int condition; //1.excellent 2.good. 3.fair 4.poor
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, double originalCost, int squareFoot, String address, int condition, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.squareFoot = squareFoot;
        this.address = address;
        this.condition = condition;
        this.lotSize = lotSize;
    }

    @Override
    //House value depends on condition and squareFoot
    public double getValue(){
        double value = switch (this.condition) {
            case 1 -> 180 * squareFoot;
            case 2 -> 130 * squareFoot;
            case 3 -> 90 * squareFoot;
            case 4 -> 80 * squareFoot;
            default -> 0;
        };

        value+= 0.25*lotSize;
        return value;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public String toString() {
        return "House{" +
                "description='" + description + '\'' +
                ", dateAcquired='" + dateAcquired + '\'' +
                ", originalCost=" + originalCost +
                ", value=" + getValue() + '\'' +
        //       ", address='" + address + '\'' +
                '}';
    }
}
