/**
 * Created by edwardbenzenberg on 6/12/17.
 */
public class Salesman extends Employee {
    // declare variables
    private double annualSales;

    // constructor
    public Salesman(String firstName, String lastName, double monthlySalary, double annualSales) {
        super(firstName, lastName, monthlySalary);
        this.annualSales = annualSales;
    }

    protected double annualSalary(){

        // declare local variables
        final float COMMISSION_MULTIPLYER = 0.2f;
        final int MAX_COMMISSION = 20000;
        double annualSalary = super.annualSalary();
        double commission = annualSales*COMMISSION_MULTIPLYER;

        if(commission > MAX_COMMISSION){
            commission = MAX_COMMISSION;
        }

        annualSalary += commission;

        return annualSalary;
    } // end annualSalary method

    public String toString(){

        return super.toString() + String.format("\nAnnual Sales: %s", super.formatter.format(annualSales));
    }

}
