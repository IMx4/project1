package com.employeeData;

/*
 * File: Employee.java
 * Author: Edward Benzenberg
 * Date:
 * Purpose: to create Employee objects and provide methods for required parameters
 */

import java.text.DecimalFormat;

public class Employee {

    // declare variables/fields
    private String firstName;
    private String lastName;
    private double monthlySalary;
    protected static DecimalFormat formatter = new DecimalFormat("$#");

    // constructor
    public Employee(String firstName, String lastName, double monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlySalary = monthlySalary;
    }

    protected double annualSalary(){
        return monthlySalary*12;
    }

    public String toString(){
        return String.format("\nEmployee Name: %s %s \nMonthly Salary: %s", firstName, lastName, formatter.format(monthlySalary));
    }

} // end Employee class
