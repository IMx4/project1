/**
 * Created by edwardbenzenberg on 6/12/17.
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class EmployeeData {

    
    ArrayList<Employee> employees2014 = new ArrayList<>();
    ArrayList<Employee> employees2015 = new ArrayList<>();
    private DecimalFormat formatter = new DecimalFormat("$#");


    /*
    readFile method - reads data from file
     */
    public void readFile() {

        File employeeFile = new File("src/employeeInfo.txt");
        BufferedReader reader = null;
        String fileLine = null;

        // validate file exists
        if (employeeFile.exists()) {
            try {
                reader = new BufferedReader(new FileReader(employeeFile));
                while ((fileLine = reader.readLine()) != null) {
                    parseEmployeeData(fileLine); // call parseEmployeeData method
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
    public void parseEmployeeData(String data) {

        String[] splitString = data.split(",| "); // split string to array

        // validate data contains required fields
        if(splitString.length >= 4) {
            createEmployeeObjects(splitString); // call createEmployeeObjects method
        } // end if

    } // end parseEmployeeData

    /*
    createEmployeeObjects - instantiates Employees and adds them to List
     */
    public void createEmployeeObjects(String[] splitString) {

        // declare local variables
        final String YEAR = splitString[0];
        final String EMPLOYEE_TYPE = splitString[1];
        final String LAST_NAME = splitString[2];
        final String FIRST_NAME = splitString[3];
        final double MONTHLY_SALARY = Double.parseDouble(splitString[4]);
        final double ANNUAL_SALES;
        final double STOCK_PRICE;

        // initialize employee object
        Employee employee = null;

        // instantiate employee object
        if (EMPLOYEE_TYPE.toLowerCase().equals("salesman")) {
            ANNUAL_SALES = Double.parseDouble(splitString[5]);

            employee = new Salesman(FIRST_NAME, LAST_NAME, MONTHLY_SALARY, ANNUAL_SALES);

         }else if (EMPLOYEE_TYPE.toLowerCase().equals("executive")) {
            STOCK_PRICE = Double.parseDouble(splitString[5]);

            employee = new Executive(FIRST_NAME, LAST_NAME, MONTHLY_SALARY, STOCK_PRICE);

        }else{
            employee = new Employee(FIRST_NAME, LAST_NAME, MONTHLY_SALARY);

        } // end if

        // add employees by year to arrayLists
        if(employee != null) {
            if (YEAR.equals("2014")) {
                employees2014.add(employee);
            } // end if

            if (YEAR.equals("2015")) {
                employees2015.add(employee);
            } // end if
        } // end if

    } // end create employeeObjects

    /*
    averageSalary method - calculates average salary of all employees per year
     */
    public double averageSalary(ArrayList<Employee> arrayList){
        int employeeCount = arrayList.size();
        double sumOfSalaraies = 0;

        for(Employee employee : arrayList){
            sumOfSalaraies += employee.annualSalary();
        } // end for each
        return sumOfSalaraies/employeeCount;

    } // end averageSalary method

    /*
    ouputData method - displays employee information
     */
    public void outputData(){

        // Emplyees from year 2014
        System.out.println("\nEmployees for year of 2014");
        for(Employee employee : employees2014){
            System.out.println(employee);
            System.out.println("Annual Salary:" + formatter.format(employee.annualSalary()));
        } // end for each
        System.out.println("\nAverage salary for 2014: " + formatter.format(averageSalary(employees2014)));

        //Employees from year 2015
        System.out.println("\nEmployees for year of 2015");
        for (Employee employee : employees2015){
            System.out.println(employee);
            System.out.println("Annual Salary: " + formatter.format(employee.annualSalary()));
        } // end for each
        System.out.println("\nAverage salary for 2015: " + formatter.format(averageSalary(employees2015)));

    } // end outputData

    /*
    initialize method - called in main to run program
     */
    public void initialize(){
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
