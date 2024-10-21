public class Employee {

    int employeeId;
    String name;
    String department;
    double payRate;
    int hoursWorked;

    public Employee(int employeeId, String name, String department, double payRate, int hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
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
        return hoursWorked<40 ? hoursWorked : 40;
    }

    public int getOvertimeHours(){
        return hoursWorked>40? hoursWorked-40 : 0;
    }

    public double getTotalPay(){
        return hoursWorked>40? 40*payRate + (hoursWorked-40)*payRate*2 : hoursWorked*payRate;
    }
}
