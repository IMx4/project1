package com.employeeData;

/*
 * File: Employee.java
 * Author: Edward Benzenberg
 * Date:
 * Purpose: to create Executive objects and provide methods for required parameters
 */

public class Executive extends Employee{

    // declare variables/fields
    private double currentStockPrice;

    // constructor
    public Executive(String firstName, String lastName, double monthlySalary, double currentStockPrice) {

        super(firstName, lastName, monthlySalary);
        this.currentStockPrice = currentStockPrice;
    }

    @Override
    protected double annualSalary(){

        // declare local variables
        final double BONUS = 30000;
        double annualSalary = super.annualSalary();

        if (currentStockPrice >= 50){
           annualSalary += BONUS;
        }

        return annualSalary;
    }

    @Override
    public String toString(){
        return super.toString() + String.format("\nCurrent Stock Price: %s", super.formatter.format(currentStockPrice));
    }
}
