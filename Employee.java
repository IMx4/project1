import java.text.DecimalFormat;

/**
 * Created by BPCT on 6/12/2017.
 */
public class Employee {

    // declare variables
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

        return monthlySalary*52;
    }

    public String toString(){


        return String.format("Employee Name: %s %s \nMonthly Salary: $%.0f", firstName, lastName, monthlySalary);
    }


} // end Employee class
