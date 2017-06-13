package com.employeeData;

/**
 * Created by BPCT on 6/12/2017.
 */

import java.text.DecimalFormat;

public class Employee {

    // declare variables/fields
    protected static DecimalFormat formatter = new DecimalFormat("$#");
    private String firstName;
    private String lastName;
    private double monthlySalary;

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
