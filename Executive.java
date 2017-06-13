/**
 * Created by edwardbenzenberg on 6/12/17.
 */
public class Executive extends Employee{

    private double currentStockPrice;

    public Executive(String firstName, String lastName, double monthlySalary, double currentStockPrice) {

        super(firstName, lastName, monthlySalary);
        this.currentStockPrice = currentStockPrice;

    }

    protected double annualSalary(){

        // declare local variables
        final double BONUS = 30000;
        double annualSalary = super.annualSalary();

        if (currentStockPrice >= 50){
           annualSalary += BONUS;
        }

        return annualSalary;
    }

    public String toString(){
        return super.toString() + String.format("\nCurrent Stock Price: %s", super.formatter.format(currentStockPrice));
    }
}
