package FilterByAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split(", ");
            Person person = new Person(data[0], Integer.parseInt(data[1]));
            people.add(person);
        }
        String group = reader.readLine();
        int years = Integer.parseInt(reader.readLine());
        filterPeople(people, group, years);

    }
    public static void filterPeople(List<Person> people, String group, int years){
        Predicate<Person> personPredicate;
        if (group.equals("older")){
            personPredicate = person -> person.getAge() >= years;
        }else {
            personPredicate = person -> person.getAge() <= years;
        }
        people.stream()
                .filter(personPredicate)
                .forEach(System.out::println);
    }
}
