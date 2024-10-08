package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLOutput;

/*
Create a new Java application named PayrollCalculator. You will read employee
data from a .csv file and generate the pay information for each employee. For
this exercise read the file using either the BufferedReader.
The file will contain several lines of employee data in the form:
id|name|hours-worked|pay-rate
For example:
10|Dana Wyatt|52.5|12.50
20|Ezra Aiden|17|16.75
30|Brittany Thibbs|40|16.50
40|Zephaniah Hughes|2|10.0
Step 1
Create an Employee class as described below:
Private data members (attributes):
- employeeId
- name
- hoursWorked
- payRate
Methods:
- parameterized constructor
- getEmployeeId() and get/set for other attributes
- getGrossPay() that calculates and returns that employee's gross pay
based on their hours worked and pay rate
Step 2
To make the main program work, you will need to:
1. Load the file using a FileReader object
2. Read each line of text
3. Split it into individual fields using the | character as the delimiter
4. Copy the values from the tokens array into variables that match the data
and then use them to create a new Employee object
5. Display the employee using a printf and by calling the employee's
getEmployeeId(), getName(), and getGrossPay() methods
6. Repeat for each line in the input file
Commit and push your code!
 */
public class PayrollCalculator {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String input = bufferedReader.readLine();
            String[] lineSplit;
            int id;
            String name;
            double hours,payRate;
            
            while( (input)!=null){
                input = bufferedReader.readLine(); //Skipping the 1st line with the column heading
                if(input!=null) {
                    lineSplit = input.split("\\|");

                    id = Integer.parseInt(lineSplit[0]);
                    name = lineSplit[1];
                    hours = Double.parseDouble(lineSplit[2]);
                    payRate = Double.parseDouble(lineSplit[3]);
                    
                    Employee employee = new Employee(id,name,hours,payRate);
                    
                    System.out.printf("id:%d Name:%s    Gross pay:$%.2f\n",employee.getEmployeeId(),employee.getName(),employee.getGrossPay());
                }
            }
            bufferedReader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
