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

    public double annualSalary(){

        return monthlySalary*52;
    }

    public String toString(){

        return "Employee Name: " + firstName + " " + lastName + " Monthly Salary: $" + monthlySalary;
    }

    class Salesman extends Employee{

        // declare variables
        private double annualSales;

        // constructor
        public Salesman(double annualSales) {
            super();
            this.annualSales = annualSales;
        }

        public double annualSalary(){

            // declare local variables
            final float COMMISSION_MULTIPLYER = 0.2f;
            final int MAX_COMMISSION = 20000;

            double commission = (annualSales*COMMISSION_MULTIPLYER)+annualSales;

            if(commission > 20000){
                commission = 20000;
            }

            return (monthlySalary*52) + commission;
        } // end annualSalary method

        public String toString(){
            return super.toString() + " Annual Sales: $" + annualSales;
        }

    } // end Salesman class

    class Executive extends Employee{

        public Executive(String firstName, String lastName, double monthlySalary) {
            super(firstName, lastName, monthlySalary);
        }
    } // end Executive class

} // end Employee class
