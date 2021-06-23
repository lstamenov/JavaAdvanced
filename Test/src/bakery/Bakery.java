package bakery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee){
        if (capacity > employees.size()){
            employees.add(employee);
        }
    }

    public boolean remove(String name){
        int beforeRemoving = employees.size();
        employees = employees.stream().
                filter(employee -> !employee.getName().equals(name))
                .collect(Collectors.toList());
        return beforeRemoving > employees.size();
    }

    public Employee getOldestEmployee(){
        final int[] oldest = {Integer.MIN_VALUE};
        employees.forEach(employee -> {
            if (employee.getAge() > oldest[0]){
                oldest[0] = employee.getAge();
            }
        });
        for (Employee e : employees) {
            if (e.getAge() == oldest[0]){
                return e;
            }
        }
        return employees.get(0);
    }

    public Employee getEmployee(String name){
        for (Employee e : employees) {
            if (e.getName().equals(name)){
                return e;
            }
        }
        return employees.get(0);
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        StringBuilder result = new StringBuilder("Employees working at Bakery {bakeryName}: ");
        for (Employee e : employees) {
            result.append(String.format("%n%s", e.toString()));
        }
        return result.toString();
    }
}
