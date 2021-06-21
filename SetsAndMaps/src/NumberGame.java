import java.util.*;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();
        int[] f = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] s = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < 20; i++) {
            firstPlayer.add(f[i]);
            secondPlayer.add(s[i]);
        }
        int count = 0;
        while (!firstPlayer.isEmpty() && !secondPlayer.isEmpty() && count < 50){
            int fCard = firstPlayer.iterator().next();
            firstPlayer.remove(fCard);
            int sCard = secondPlayer.iterator().next();
            secondPlayer.remove(sCard);
            if (fCard > sCard){
                firstPlayer.add(fCard);
                firstPlayer.add(sCard);
            }else if (sCard > fCard){
                secondPlayer.add(fCard);
                secondPlayer.add(sCard);
            }
            count++;
        }
        if (count == 50){
            if (firstPlayer.size() > secondPlayer.size()){
                System.out.println("First player win!");
            }else if (secondPlayer.size() > firstPlayer.size()){
                System.out.println("Second player win!");
            }else {
                System.out.println("Draw!");
            }
        }else {
            if (firstPlayer.isEmpty()){
                System.out.println("Second player win!");
            }else {
                System.out.println("First player win!");
            }
        }
    }
}
