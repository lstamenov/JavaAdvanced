package OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] arr = scanner.nextLine().split(" ");
            Person person = new Person(arr[0], Integer.parseInt(arr[1]));
            people.add(person);
        }
        people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .filter(person -> person.getAge() > 30)
                .forEach(System.out::println);
    }
}
