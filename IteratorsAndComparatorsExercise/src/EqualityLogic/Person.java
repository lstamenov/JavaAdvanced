package EqualityLogic;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        if (this.age == o.getAge()){
            return this.name.compareTo(o.getName());
        }else {
            return Integer.compare(this.age, o.age);
        }
    }
}
