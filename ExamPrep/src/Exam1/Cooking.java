package Exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> liquidNumbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> ingredientsNumbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(ingredientsNumbers);
        ArrayDeque<Integer> liquids = new ArrayDeque<>(liquidNumbers);
        ArrayDeque<Integer> ingredients = new ArrayDeque<>(ingredientsNumbers);

        Map<String, Integer> products = new TreeMap<>(Map.of("Bread", 0, "Cake", 0,
              "Pastry", 0, "Fruit Pie", 0));
        while (!liquids.isEmpty() && !ingredients.isEmpty()){
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();

            switch (liquid + ingredient){
                case 25:
                    products.merge("Bread", 1, Integer::sum);
                    break;
                case 50:
                    products.merge("Cake", 1, Integer::sum);
                    break;
                case 75:
                    products.merge("Pastry", 1, Integer::sum);
                    break;
                case 100:
                    products.merge("Fruit Pie", 1, Integer::sum);
                    break;
                default:
                    ingredients.push(ingredient + 3);
                    break;
            }
        }
        String result = isEveryProductCooked(products) ? "Wohoo! You succeeded in cooking all the food!"
                : "Ugh, what a pity! You didn't have enough materials to to cook everything.";
        System.out.println(result);
        System.out.print("Liquids left: ");
        if (liquids.isEmpty()){
            System.out.println("none");
        }else {
            while (!liquids.isEmpty()) {
                if (liquids.size() == 1) {
                    System.out.println(liquids.poll());
                } else {
                    System.out.print(liquids.poll() + ", ");
                }
            }
        }
        System.out.print("Ingredients left: ");
        if (ingredients.isEmpty()){
            System.out.println("none");
        }else {
            while (!ingredients.isEmpty()) {
                if (ingredients.size() == 1) {
                    System.out.printf("%s%n", ingredients.pop());
                } else {
                    System.out.print(ingredients.pop() + ", ");
                }
            }
        }

        for (Map.Entry<String, Integer> e : products.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

    private static boolean isEveryProductCooked(Map<String, Integer> products) {
        for (Map.Entry<String, Integer> e : products.entrySet()) {
            if (e.getValue() == 0){
                return false;
            }
        }
        return true;
    }
}
