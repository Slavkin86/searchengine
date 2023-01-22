import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Company company = new Company();
//        Operator operator = new  Operator();
//        Employee operator1 = new Operator();
//        company.hire(operator);
//        company.hire(operator1);

        List<Employee> workers = new ArrayList<>();
        for (int i = 0; i < 180; i++) {
            company.hire(new Operator());
        }

        for (int i = 0; i < 80; i++) {
            company.hire(new Manager());
        }

        for (int i = 0; i < 10; i++) {
            company.hire(new TopManager(company));
        }
        company.hireAll(workers);

        List<Employee> topSalaruStaff = company.getTopSalaryStaff(10);
        for (Employee e : topSalaruStaff) {
            System.out.println(e.getMonthSalary());
        }
        System.out.println("-----------------------");

        List<Employee> lowSalaruStaff = company.getLowestSalaryStaff(10);
        for (Employee e : lowSalaruStaff) {
            System.out.println(e.getMonthSalary());
        }
        printEmployees(company);
        System.out.println("-----------------------");
        List<Employee> employees = company.getEmployees();
        System.out.println(employees.size());
        for (int i =0; i < 135; i++) {
            company.fire(employees.get(i));
        }
        System.out.println(company.getEmployees().size());
    }
    private static void printEmployees(Company company) {
        List<Employee> topSalaruStaff = company.getTopSalaryStaff(10);
        for (Employee e : topSalaruStaff) {
            System.out.println(e.getMonthSalary());
        }
        System.out.println("-----------------------");
        List<Employee> lowSalaruStaff = company.getLowestSalaryStaff(10);
        for (Employee e : lowSalaruStaff) {
            System.out.println(e.getMonthSalary());
        }
    }
}