package com.pluralsight;

import java.time.LocalDateTime;

public class Employee {

    int employeeId;
    String name,department;
    double payRate,hoursWorked,clockInTimeAsDouble,clockOutTimeAsDouble;
    LocalDateTime clockInTime, clockOutTime;

    public Employee(int employeeId, String name, String department, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked =0;
    }

    public void punchIn(double time){
        clockInTimeAsDouble = time;
    }

    public void punchOut(double time){
        clockOutTimeAsDouble = time;
        hoursWorked+= (int)(clockOutTimeAsDouble-clockInTimeAsDouble);
    }

    public void punchIn(){
        clockInTime = LocalDateTime.now();
    }

    public void punchOut(){
        clockOutTime = LocalDateTime.now();
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

    public double getRegularHours(){
        return Math.min(hoursWorked, 40);
    }

    public double getOvertimeHours(){ return hoursWorked>40? hoursWorked-40 : 0; }

    public double getTotalPay(){
        //Overtime pay is double the usual pay rate
        return getRegularHours()*payRate + getOvertimeHours()*2*payRate;
    }
}
