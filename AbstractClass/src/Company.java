import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company implements Comparator<Employee> {
    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    private List<Employee> employees = new ArrayList<>();

    public void hire(Employee employee) {
        employees.add(employee);
    }
    public void hireAll(List<Employee> employee) {
        for (Employee e : employee) {
            hire(e);
        }
    }
    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public int getIncome() {
        int income = 0;
        for (Employee e : employees) {
            if (e instanceof Manager) {
                income += ((Manager) e).getSales();
            }
        }
        return income;

    }
    public List<Employee> getTopSalaryStaff(int count) {
        if (count < 0) {
            return Collections.emptyList();
        }
        if (count < employees.size()) {
            count = employees.size();
        }
        Collections.sort(employees);
        Collections.reverse(employees);
        return employees.subList(0, count);
    }
    public List<Employee> getLowestSalaryStaff(int count) {
        Collections.sort(employees);
        return employees.subList(0, count);
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        return 0;
    }
}
