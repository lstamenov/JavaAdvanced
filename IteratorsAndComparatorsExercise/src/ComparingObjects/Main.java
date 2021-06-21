package ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();
        String string = reader.readLine();
        while (!string.equals("END")){
            String[] personData = string.split("\\s+");
            Person person = new Person(personData[0], Integer.parseInt(personData[1]), personData[2]);
            people.add(person);

            string = reader.readLine();
        }
        Person person = people.get(Integer.parseInt(reader.readLine()) - 1);
        int countSame = 0;
        for (Person p : people) {
            if (p.compareTo(person) == 0){
                countSame++;
            }
        }
        if (countSame == 1){
            System.out.println("No matches");
        }else {
            System.out.printf("%d %d %d", countSame, people.size() - countSame, people.size());
        }
    }
}
