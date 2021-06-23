package bombs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> bombEffects = Arrays.stream(reader.readLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        List<Integer> bombCasingNums = Arrays.stream(reader.readLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(bombCasingNums);
        ArrayDeque<Integer> bombCasings = new ArrayDeque<>(bombCasingNums);
        Map<String, Integer> bombs = new TreeMap<>(Map.of("Datura Bombs", 0,
                "Cherry Bombs", 0, "Smoke Decoy Bombs", 0));
        while (!bombEffects.isEmpty() && !bombCasings.isEmpty() && !areAllBombsCollected(bombs)){
            int effect = bombEffects.removeFirst();
            int casing = bombCasings.pop();
            int sum = effect + casing;
            while (sum != 40 && sum != 60 && sum != 120){
                sum -= 5;
            }
            switch (sum){
                case 40:
                    bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
                    break;
                case 60:
                    bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
                    break;
                case 120:
                    bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
                    break;
            }
        }
        String result = !areAllBombsCollected(bombs) ? "You don't have enough materials to fill the bomb pouch."
                : "Bene! You have successfully filled the bomb pouch!";
        System.out.println(result);
        System.out.print("Bomb Effects: ");
        if (bombEffects.isEmpty()){
            System.out.println("empty");
        }else {
            while (!bombEffects.isEmpty()){
                if (bombEffects.size() == 1){
                    System.out.println(bombEffects.poll());
                }else {
                    System.out.print(bombEffects.poll() + ", ");
                }
            }
        }
        System.out.print("Bomb Casings: ");
        if (bombCasings.isEmpty()){
            System.out.println("empty");
        }else {
            while (!bombCasings.isEmpty()){
                if (bombCasings.size() == 1){
                    System.out.println(bombCasings.pop());
                }else {
                    System.out.print(bombCasings.pop() + ", ");
                }
            }
        }
        for (Map.Entry<String, Integer> e : bombs.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

    private static boolean areAllBombsCollected(Map<String, Integer> bombs) {
        for (Map.Entry<String, Integer> e : bombs.entrySet()) {
            if (e.getValue() < 3){
                return false;
            }
        }
        return true;
    }
}
