package com.pluralsight;

public class App {

    public static void main(String[] args) {
        Employee jack = new Employee(1,"Jack","Security",40);
        Employee jill = new Employee(2,"Jill","Administration",40);

        jack.punchIn(9);
        jack.punchOut(17);
        jack.punchIn(9);
        jack.punchOut(17);
        jack.punchIn(9);
        jack.punchOut(17);
        jack.punchIn(9);
        jack.punchOut(17);
        jack.punchIn(9);
        jack.punchOut(20);
        System.out.println("Jack's regular hours: "+jack.getRegularHours());
        System.out.println("Jack's overtime: "+jack.getOvertimeHours());
        System.out.println("Jack's pay: "+jack.getTotalPay());

        System.out.println();
        jill.punchIn(8);
        jill.punchOut(17);
        jill.punchIn(8);
        jill.punchOut(17);
        jill.punchIn(8);
        jill.punchOut(17);
        jill.punchIn(8);
        jill.punchOut(17);
        jill.punchIn(8);
        jill.punchOut(20);
        System.out.println("Jill's regular hours: "+jill.getRegularHours());
        System.out.println("Jill's overtime: "+jill.getOvertimeHours());
        System.out.println("Jill's pay: "+jill.getTotalPay());

        Reservation reservation = new Reservation("double",4);
        System.out.println("Cost : "+reservation.getReservationTotal());
    }
}
