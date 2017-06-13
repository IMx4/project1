import java.text.DecimalFormat;

/**
 * Created by BPCT on 6/12/2017.
 */
public class Employee {

    // declare variables
    protected DecimalFormat formatter = new DecimalFormat("$#");
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
        double annualSalary = monthlySalary*12;
        return annualSalary;
    }

    public String toString(){
        return String.format("\nEmployee Name: %s %s \nMonthly Salary: %s", firstName, lastName, formatter.format(monthlySalary));
    }

} // end Employee class
