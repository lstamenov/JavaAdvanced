package StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Set<Person> people = new TreeSet<>(new ComparingByAge());
        Set<Person> people1 = new TreeSet<>(new ComparingByName());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            people.add(person);
            people1.add(person);
        }
        people.stream()
                .sorted(new ComparingByAge())
                .forEach(person -> System.out.println(person.getName() + " " + person.getAge()));

        people.stream()
                .sorted(new ComparingByName())
                .forEach(person -> System.out.println(person.getName() + " " + person.getAge()));
    }
}
