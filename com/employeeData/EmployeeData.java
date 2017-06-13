package com.employeeData; /**
 * Created by edwardbenzenberg on 6/12/17.
 */

import java.io.*;
import java.util.ArrayList;

public class EmployeeData {


    private ArrayList<Employee> employees2014 = new ArrayList<>();
    private ArrayList<Employee> employees2015 = new ArrayList<>();

    /*
    readFile method - reads data from file
     */
    private void readFile() {

        File employeeFile = new File("src/employeeInfo.txt");
        BufferedReader reader = null;
        String fileLine;

        // validate file exists
        if (employeeFile.exists()) {
            try {
                reader = new BufferedReader(new FileReader(employeeFile));
                while ((fileLine = reader.readLine()) != null) {
                    parseEmployeeData(fileLine); // call parseEmployeeData method and pass String
                } // end while

            } catch (Exception e) {
                e.printStackTrace();

            } finally {

                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } // end try/catch

        } else {
            System.out.println("File Does Not Exist");
        } // end if

    } // end readFile method

    /*
    parseEmployeeData - prepares string for creating objects
     */
    private void parseEmployeeData(String data) {

        String[] splitString = data.split("[, ]"); // split string to array

        // validate data contains required fields
        if (splitString.length >= 4) {
            createEmployeeObjects(splitString); // call createEmployeeObjects method
        } // end if

    } // end parseEmployeeData

    /*
    createEmployeeObjects - instantiates Employees and adds them to List
     */
    private void createEmployeeObjects(String[] splitString) {

        // declare local variables
        final String YEAR = splitString[0];
        final String EMPLOYEE_TYPE = splitString[1];
        final String LAST_NAME = splitString[2];
        final String FIRST_NAME = splitString[3];
        final double MONTHLY_SALARY = Double.parseDouble(splitString[4]);
        final double ANNUAL_SALES;
        final double STOCK_PRICE;

        // initialize employee object
        Employee employee;

        // instantiate employee object
        if (EMPLOYEE_TYPE.toLowerCase().equals("salesman")) {
            ANNUAL_SALES = Double.parseDouble(splitString[5]);

            employee = new Salesman(FIRST_NAME, LAST_NAME, MONTHLY_SALARY, ANNUAL_SALES);

        } else if (EMPLOYEE_TYPE.toLowerCase().equals("executive")) {
            STOCK_PRICE = Double.parseDouble(splitString[5]);

            employee = new Executive(FIRST_NAME, LAST_NAME, MONTHLY_SALARY, STOCK_PRICE);

        } else {
            employee = new Employee(FIRST_NAME, LAST_NAME, MONTHLY_SALARY);

        } // end if

        // validate employee and call addEmployeeToArray method
        if (employee != null) {
            addEmployeeToArray(YEAR, employee);
        } // end if

    } // end create employeeObjects

    /*
    addEmployeeToArray - adds employee to array
     */
    private void addEmployeeToArray(String year, Employee employee) {

        if (year.equals("2014")) {
            employees2014.add(employee);
        } // end if

        if (year.equals("2015")) {
            employees2015.add(employee);
        } // end if
    } // end addEmployeeToArray

    /*
    averageSalary method - calculates average salary of all employees per year
     */
    private double averageSalary(ArrayList<Employee> arrayList) {
        int employeeCount = arrayList.size();
        double sumOfSalaries = 0;

        for (Employee employee : arrayList) {
            sumOfSalaries += employee.annualSalary();
        } // end for each
        return sumOfSalaries / employeeCount;

    } // end averageSalary method

    /*
    ouputData method - displays employee information
     */
    private void outputData() {

        // Employees from year 2014
        System.out.println("\nEmployees for year of 2014");
        for (Employee employee : employees2014) {
            System.out.println(employee);
            System.out.println("Annual Salary:" + Employee.formatter.format(employee.annualSalary()));
        } // end for each
        System.out.println("\nAverage salary for 2014: " + Employee.formatter.format(averageSalary(employees2014)));

        //Employees from year 2015
        System.out.println("\nEmployees for year of 2015");
        for (Employee employee : employees2015) {
            System.out.println(employee);
            System.out.println("Annual Salary: " + Employee.formatter.format(employee.annualSalary()));
        } // end for each
        System.out.println("\nAverage salary for 2015: " + Employee.formatter.format(averageSalary(employees2015)));

    } // end outputData

    /*
    initialize method - called in main to run program
     */
    private void initialize() {
        readFile();
        outputData();

    }

    /*
    main method
     */
    public static void main(String[] args) {
        EmployeeData data = new EmployeeData();
        data.initialize();

    } // end Main method
} // end EmployeeData class
