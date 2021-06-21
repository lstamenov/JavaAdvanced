package CompanyRoaster;

public class Employee {
    String name;
    double salary;
    String position;
    String email = "n/a";
    int age = -1;

    Employee(String name, double salary, String position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f %s %d",
                getName(), getSalary(), getEmail(), getAge());
    }
}
