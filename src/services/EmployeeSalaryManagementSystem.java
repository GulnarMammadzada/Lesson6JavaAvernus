package services;

import java.util.Arrays;
import java.util.Scanner;

public class EmployeeSalaryManagementSystem {
    public static void main(String[] args) {
        String[] employeeNames = new String[2];
        double[] salaries = new double[2];
        String[] departments = new String[2];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < employeeNames.length; i++) {
            System.out.println("Enter employee names: ");
            employeeNames[i] = scanner.nextLine();

            System.out.println("Enter salarie of " + employeeNames[i] + ":");
            salaries[i] = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Enter department of " + employeeNames[i] + ":");
            departments[i] = scanner.nextLine();
        }

        displayInformation(employeeNames, salaries, departments);
        displayHighestAndLowestSalary(employeeNames, salaries, departments);
        averageSalary(salaries);

        System.out.print("Enter an employee's name to search: ");
        String searchName = scanner.nextLine();

        int index = searchEmployee(employeeNames, searchName);
        if (index != -1) {
            displayEmployeeInfo(employeeNames, salaries, departments, index);

            updateSalary(scanner, employeeNames, salaries, index);
        } else {
            System.out.println("Employee not found.");
        }
        displayAllEmployees(employeeNames, salaries, departments);



    }

    public static void displayInformation(String[] names, double[] salaries, String[] departments) {
        System.out.println("\nEmployee details:");
        Arrays.sort(salaries);
        for (int i = 0; i < names.length; i++) {
            System.out.println("Name: " + names[i]
                    + ", Salary: " + salaries[i]
                    + ", Department: " + departments[i]);
        }
    }


    public static void displayHighestAndLowestSalary(String[] names, double[] salaries, String[] departments) {

        int indexHighest = 0;
        int indexLowest = 0;

        for (int i = 1; i < salaries.length; i++) {
            if (salaries[i] > salaries[indexHighest]) {
                indexHighest = i;
            }
            if (salaries[i] < salaries[indexLowest]) {
                indexLowest = i;
            }
        }

        System.out.println("\nEmployee with highest salary:");
        System.out.println("Name: " + names[indexHighest]
                + ", Salary: " + salaries[indexHighest]
                + ", Department: " + departments[indexHighest]);

        System.out.println("\nEmployee with lowest salary:");
        System.out.println("Name: " + names[indexLowest]
                + ", Salary: " + salaries[indexLowest]
                + ", Department: " + departments[indexLowest]);


    }

    public static void averageSalary(double[] salaries) {
        double average = Arrays.stream(salaries).average().getAsDouble();
        System.out.println("\nAverage salary for employees: ");
        System.out.println(average);
    }


    public static int searchEmployee(String[] names, String searchName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(searchName)) {
                return i;
            }
        }
        return -1;
    }


    public static void displayEmployeeInfo(String[] names, double[] salaries, String[] departments, int index) {
        System.out.println(names[index] + " works in " + departments[index] + " and earns $" + salaries[index]);
    }

    public static void updateSalary(Scanner scanner, String[] names, double[] salaries, int index) {
        System.out.print("Do you want to update " + names[index] + "'s salary? (yes/no): ");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            System.out.print("Enter the new salary for " + names[index] + ": ");
            double newSalary = scanner.nextDouble();
            salaries[index] = newSalary;
            System.out.println(names[index] + "'s salary has been updated to: $" + newSalary);
        }
    }

    public static void displayAllEmployees(String[] names, double[] salaries, String[] departments) {
        System.out.println("\nUpdated Employee Information:");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " works in " + departments[i] + " and earns $" + salaries[i]);
        }
    }
}


