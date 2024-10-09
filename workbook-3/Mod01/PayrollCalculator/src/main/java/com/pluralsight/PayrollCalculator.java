package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

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

Continue working on the PayrollCalculator program.
Rather than displaying your payroll report to the screen, write it to a .csv file in
the following format.
id|name|gross pay
111|Cameron Tay|3277.65
222|James Tee|2150.00
Prompt the user for the name of a file to read and process, then prompt them for
the name of the payroll file to create.
Enter the name of the file employee file to process: employees.csv
Enter the name of the payroll file to create: payroll-sept-2023.csv
When your program finishes running, open the new file in Notepad to view the
results.
BONUS: If the user chooses specifies a .json extension write the data as JSON
instead of csv.
For example:
Enter the name of the file employee file to process: employees.csv
Enter the name of the payroll file to create: payroll-sept-2023.json
payroll-sept-2023.json
[
{ "id": 111, "name" : "Cameron Tay", "grossPay" : 3277.65 },
{ "id": 222, "name" : "James Tee", "grossPay" : 2150.00 }
]
Commit and push your code!

 */
public class PayrollCalculator {
    public static void main(String[] args) {
        try {
            Scanner userInput = new Scanner(System.in);
            System.out.print("Enter the name of the employee file to process:");
            String employeeFileName = userInput.nextLine().trim();
            System.out.print("Enter the name of the payroll file to create:");
            String payrollFileName = userInput.nextLine().trim();
            FileReader fileReader = new FileReader("src/main/resources/" + employeeFileName);
            BufferedReader inputReader = new BufferedReader(fileReader);

            String input = inputReader.readLine(); //Skipping the 1st line with the column heading
            String[] lineSplit;
            int id;
            String name;
            double hours, payRate;

            FileWriter fileWriter = new FileWriter(payrollFileName, false);
            BufferedWriter outputWriter = new BufferedWriter(fileWriter);
            String output;

            if (payrollFileName.endsWith(".json")) {
                outputWriter.write("[\n");
                while ((input) != null) {
                    input = inputReader.readLine();
                    if (input != null) {
                        lineSplit = input.split("\\|");

                        id = Integer.parseInt(lineSplit[0]);
                        name = lineSplit[1];
                        hours = Double.parseDouble(lineSplit[2]);
                        payRate = Double.parseDouble(lineSplit[3]);

                        Employee employee = new Employee(id, name, hours, payRate);
                        output = String.format("\t{ \"id\": %d, \"name\" : \"%s\", \"grossPay\" : %.2f }\n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
                        System.out.print(output);
                        outputWriter.write(output);
                    }
                }
                outputWriter.write("]\n");
             /*Had a bug where the program wasn't writing what was in the buffer unless I used flush(),
             Seems to have been caused by me forgetting the close() method which flushes the buffer before closing it
              */
             //   outputWriter.flush();
                inputReader.close();
                outputWriter.close();
            }
            else{
                outputWriter.write("id|name|gross pay\n");
                while ((input) != null) {
                    input = inputReader.readLine();
                    if (input != null) {
                        lineSplit = input.split("\\|");

                        id = Integer.parseInt(lineSplit[0]);
                        name = lineSplit[1];
                        hours = Double.parseDouble(lineSplit[2]);
                        payRate = Double.parseDouble(lineSplit[3]);

                        Employee employee = new Employee(id, name, hours, payRate);
                        output = String.format("%d|%s|$%.2f\n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
                        //System.out.print(output);
                        outputWriter.write(output);
                    }
                }
            inputReader.close();
            outputWriter.close();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
