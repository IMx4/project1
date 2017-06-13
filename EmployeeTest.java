/**
 * Created by edwardbenzenberg on 6/12/17.
 */
public class EmployeeTest {

    public static void main(String[] args) {
        Salesman salesman = new Salesman("Ed", "Benz", 2000, 60000);
        System.out.println(salesman);

        Employee employee = new Employee("Mike", "T", 2000);
        System.out.println(employee);
    }
}
