package CompanyRoaster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Department> departments = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            Employee employee = new Employee(name, salary, position);
            String departmentName = input[3];
            switch (input.length){
                case 5:
                    if (input[4].length() <= 3){
                        employee.setAge(Integer.parseInt(input[4]));
                    }else {
                        employee.setEmail(input[4]);
                    }
                    break;
                case 6:
                    employee.setEmail(input[4]);
                    employee.setAge(Integer.parseInt(input[5]));
                    break;
            }
            int depIndex = isSuchDepartment(departmentName, departments);
            if (depIndex != -1){
                departments.get(depIndex).addEmployee(employee);
            }else {
                Department department = new Department(departmentName);
                department.addEmployee(employee);
                departments.add(department);
            }
        }
        departments.stream()
                .sorted(Comparator.comparing(Department::getAverageSalary).reversed())
                .limit(1)
                .forEach(department -> {
                    System.out.println("Highest Average Salary: " + department.getName());
                    department.getEmployees()
                            .stream()
                            .sorted(Comparator.comparing(Employee::getSalary).reversed())
                            .forEach(System.out::println);
                });
    }

    private static int isSuchDepartment(String departmentName, List<Department> departments) {
        for (Department d : departments) {
            if (d.getName().equals(departmentName)){
                return departments.indexOf(d);
            }
        }
        return -1;
    }
}
