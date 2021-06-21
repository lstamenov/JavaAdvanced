package CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Cat> cats = new ArrayList<>();
        String input = br.readLine();
        while (!input.equals("End")){
            String[] data = input.split("\\s+");
            String breed = data[0];
            String name = data[1];
            double var = Double.parseDouble(data[2]);
            Cat cat = new Cat(name, breed, var);
            cats.add(cat);
            input = br.readLine();
        }
        String catName = br.readLine();
        cats.
                stream()
                .filter(cat -> cat.getName().equals(catName))
                .forEach(System.out::println);
    }
}
