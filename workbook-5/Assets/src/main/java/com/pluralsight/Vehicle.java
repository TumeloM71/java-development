package com.pluralsight;

public class Vehicle extends Asset{

    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.setMakeModel(makeModel);
        this.setYear(year);
        this.setOdometer(odometer);
    }

    //0-3 years. Original cost decreases by 3% annually
    //4-6 years. Original cost decreases by 6% annually
    //7-10 years. Original cost decreases by 8% annually
    // >10 years. value = 1000
    @Override
    public double getValue(){
        double value;

        if( year>=0 && year<=3)
            value = originalCost - (0.03*originalCost*year);

        else if (year>=4 && year<=6)
            value = originalCost - (0.06*originalCost*year);

        else if (year>=7 && year<=10)
            value = originalCost - (0.08*originalCost*year);

        else
            value = 1000;

        if( odometer>100000 && !makeModel.contains("Toyota")
        && !makeModel.contains("Honda"))
            value = 0.75*value;

        return value;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "description='" + description + '\'' +
                ", dateAcquired='" + dateAcquired + '\'' +
                ", originalCost=" + originalCost +
                ", value=" + getValue() + '\'' +
        //        ", makeModel='" + makeModel + '\'' +
                '}';
    }
}
