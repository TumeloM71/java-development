public class App {

    public static void main(String[] args) {
        Employee jack = new Employee(1,"Jack","Security",40, 50);
        Employee jill = new Employee(1,"Jill","Administration",40, 40);

        System.out.println("Jack's regular hours: "+jack.getRegularHours());
        System.out.println("Jack's overtime: "+jack.getOvertimeHours());
        System.out.println("Jack's pay: "+jack.getTotalPay());

        System.out.println("Jill's regular hours: "+jill.getRegularHours());
        System.out.println("Jill's overtime: "+jill.getOvertimeHours());
        System.out.println("Jill's pay: "+jill.getTotalPay());
        System.out.println();

        Reservation reservation = new Reservation("double",14);
        System.out.println("Cost : "+reservation.getReservationTotal());
    }
}
