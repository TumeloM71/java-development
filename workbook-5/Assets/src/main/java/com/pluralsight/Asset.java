package com.pluralsight;

public class Asset {
    protected String description;
    protected String dateAcquired;
    protected double originalCost;

    public Asset(String description, String dateAcquired, double originalCost) {
        this.setDescription(description);
        this.setDateAcquired(dateAcquired);
        this.setOriginalCost(originalCost);
    }

    public double getValue(){
        return getOriginalCost();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public double getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(double originalCost) {
        this.originalCost = originalCost;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "description='" + getDescription() + '\'' +
                ", dateAcquired='" + getDateAcquired() + '\'' +
                ", originalCost=" + getOriginalCost() +
                ", value="+ getValue() + '\'' +
                '}';
    }
}
