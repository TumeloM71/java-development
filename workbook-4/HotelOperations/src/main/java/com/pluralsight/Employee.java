package com.pluralsight;

import java.time.Duration;
import java.time.LocalDateTime;

public class Employee {

    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double clockInTimeAsDouble;
    private double clockOutTimeAsDouble;
    private LocalDateTime clockInTime;
    private LocalDateTime clockOutTime;

    public Employee(int employeeId, String name, String department, double payRate) {
        this.setEmployeeId(employeeId);
        this.setName(name);
        this.setDepartment(department);
        this.setPayRate(payRate);
        this.setHoursWorked(0);
    }

    public void punchIn(double time){
        setClockInTimeAsDouble(time);
    }

    public void punchOut(double time){
        setClockOutTimeAsDouble(time);
        setHoursWorked(getHoursWorked() + (int)(getClockOutTimeAsDouble() - getClockInTimeAsDouble()));
    }

    public void punchIn(){
        setClockInTime(LocalDateTime.now());
    }

    public void punchOut(){
        setClockOutTime(LocalDateTime.now());
        setHoursWorked(getHoursWorked() + ( Duration.between(getClockInTime(), getClockOutTime()).toMinutes() )/60.0);
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
        return Math.min(getHoursWorked(), 40);
    }

    public double getOvertimeHours(){ return getHoursWorked() >40? getHoursWorked() -40 : 0; }

    public double getTotalPay(){
        //Overtime pay is 1.5 the usual pay rate
        return getRegularHours()* getPayRate() + getOvertimeHours()*1.5* getPayRate();
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getClockInTimeAsDouble() {
        return clockInTimeAsDouble;
    }

    public void setClockInTimeAsDouble(double clockInTimeAsDouble) {
        this.clockInTimeAsDouble = clockInTimeAsDouble;
    }

    public double getClockOutTimeAsDouble() {
        return clockOutTimeAsDouble;
    }

    public void setClockOutTimeAsDouble(double clockOutTimeAsDouble) {
        this.clockOutTimeAsDouble = clockOutTimeAsDouble;
    }

    public LocalDateTime getClockInTime() {
        return clockInTime;
    }

    public void setClockInTime(LocalDateTime clockInTime) {
        this.clockInTime = clockInTime;
    }

    public LocalDateTime getClockOutTime() {
        return clockOutTime;
    }

    public void setClockOutTime(LocalDateTime clockOutTime) {
        this.clockOutTime = clockOutTime;
    }
}
