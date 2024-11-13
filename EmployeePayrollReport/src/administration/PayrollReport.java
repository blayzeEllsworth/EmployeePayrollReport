/**
 * 
 */
package administration;

import employees.Employee;
import employees.HourlyEmployee;
import employees.SalariedEmployee;
import employees.StudentEmployee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 */
public class PayrollReport {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Creates a list to store employees
        List<Employee> employees = new ArrayList<>();

        // Get the number of employees from the user
        System.out.print("How many employees would you like to enter? ");
        int userInput = scanner.nextInt();
        scanner.nextLine();  

        // Loop to create and add employees based on user input
        for (int i = 0; i < userInput; i++) {
            // Get basic employee details
            System.out.println("\nEnter details for employee " + (i + 1) + "...");
            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter employee number: ");
            int employeeNumber = scanner.nextInt();
            scanner.nextLine();  

            // Ask for employee type so they can be designated to one of my classes
            System.out.print("Enter employee type (Salaried, Hourly, Student): ");
            String type = scanner.nextLine().toLowerCase();

            // Create employee based on instance declared by user
            Employee employee = null;
            if (type.equals("salaried")) {
                System.out.print("Enter annual salary: ");
                double salary = scanner.nextDouble();
                scanner.nextLine();
                employee = new SalariedEmployee(firstName, lastName, employeeNumber, salary);
            } else if (type.equals("hourly")) {
                System.out.print("Enter hourly rate: ");
                double hourlyRate = scanner.nextDouble();
                System.out.print("Enter number of hours worked per month: ");
                int hoursWorked = scanner.nextInt();
                scanner.nextLine();  
                employee = new HourlyEmployee(firstName, lastName, employeeNumber, hoursWorked, hourlyRate);
            } else if (type.equals("student")) {
                System.out.print("Enter hourly rate: ");
                double hourlyRate = scanner.nextDouble();
                System.out.print("Enter number of hours worked per month: ");
                int hoursWorked = scanner.nextInt();
                scanner.nextLine();  
                employee = new StudentEmployee(firstName, lastName, employeeNumber, hoursWorked, hourlyRate);
            } else {
                //Create error message for invalid input
            	System.out.println("Invalid employee type. Please enter Salaried, Hourly, or Student.");
                i--; 
                continue;
            }

            // Add the employee to the list
            employees.add(employee);
        }

        // This creates the label at the top of the report
        System.out.println("\n***** Payroll Report *****");
        System.out.println("--------------------------------------------------------------------------------");

        // Calculate and display payroll details
        double monthlyPaySum = 0.0;

        //Goes through each item and uses the appropriate method for their respective class
        for (Employee employee : employees) {
            System.out.println(employee.toString());
            monthlyPaySum += employee.getMonthlyPay();
        }

        // Format the total payroll value
        String totalPayroll = String.format("%,.2f", monthlyPaySum);

        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-15s $%-10s\n", "Total Payroll:", totalPayroll);

        // Close the scanner
        scanner.close();
    }
}
