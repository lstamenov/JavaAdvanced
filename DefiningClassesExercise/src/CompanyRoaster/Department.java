package CompanyRoaster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;

    Department (String name) {
        this.name= name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getAverageSalary(){
        double sum = 0;
        for (Employee e : employees) {
            sum += e.getSalary();
        }
        return sum / employees.size();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
}
