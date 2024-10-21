public class Employee {

    int employeeId;
    String name;
    String department;
    double payRate;
    int hoursWorked;
    double clockInTime;
    double clockOutTime;

    public Employee(int employeeId, String name, String department, double payRate, int hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public void punchTimeCard(double time, boolean clockingIn){
        if (clockingIn)
            clockInTime = time;
        else
            clockOutTime = time;
    }



    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getRegularHours(){
        return Math.min(hoursWorked, 40);
    }

    public int getOvertimeHours(){
        return hoursWorked>40? hoursWorked-40 : 0;
    }

    public double getTotalPay(){
        return hoursWorked>40? 40*payRate + (hoursWorked-40)*payRate*2 : hoursWorked*payRate;
    }
}
