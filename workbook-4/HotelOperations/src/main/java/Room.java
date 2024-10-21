public class Room {

    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    public Room(double price, int numberOfBeds, boolean isOccupied, boolean isDirty) {
        this.price = price;
        this.numberOfBeds = numberOfBeds;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isAvailabe(){
        return !isOccupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }
}
