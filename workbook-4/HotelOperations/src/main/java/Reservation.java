import java.time.LocalDate;

public class Reservation {

    private String roomType;
    private double price; //per night, 139 for roomType 'king' and 124 for type 'double'
    private int numberOfNights;
    private int weekendDays;
    private boolean isWeekend; //price is 10% higher on weekends

    public Reservation(String roomType, int numberOfNights) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.price = roomType.equals("king") ? 139 : 124;
        this.weekendDays = numberOfWeekendDays(LocalDate.now(), LocalDate.now().plusDays(numberOfNights));
        this.isWeekend = weekendDays > 0;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public void setIsWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    public double getReservationTotal(){
        return weekendDays*price*1.1 + (numberOfNights-weekendDays)*price;
    }
    public int numberOfWeekendDays(LocalDate start, LocalDate end){
        LocalDate day = start;
        int numOfWeekendDays = 0;
        while (!day.isAfter(end)){
            if (day.getDayOfWeek().getValue() == 6 || day.getDayOfWeek().getValue() == 7)
                numOfWeekendDays++;

            day = day.plusDays(1);
        }
        return numOfWeekendDays;
    }

}
