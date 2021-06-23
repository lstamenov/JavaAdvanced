package flowers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> liliesN = Arrays.stream(reader.readLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> rosesN = Arrays.stream(reader.readLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(liliesN);
        ArrayDeque<Integer> lilies = new ArrayDeque<>(liliesN);
        ArrayDeque<Integer> roses = new ArrayDeque<>(rosesN);
        ArrayDeque<Integer> storedFlowers = new ArrayDeque<>();
        int wreaths = 0;
        while (!lilies.isEmpty() && !roses.isEmpty()){
            int lilie = lilies.pop();
            int rose = roses.removeFirst();
            int sum = lilie + rose;
            if (sum == 15){
                wreaths++;
            }else if (sum > 15){
                sum -= 2;
                if (sum == 15){
                    wreaths++;
                }else {
                    while (sum > 15){
                        sum -= 2;
                    }
                    if (sum == 15) {
                        wreaths++;
                    } else {
                        storedFlowers.push(sum);
                    }
                }
            }else {
                storedFlowers.push(sum);
            }
        }
        int storedSum = 0;
        if (storedFlowers.size() > 1){
            while (!storedFlowers.isEmpty()){
                storedSum += storedFlowers.pop();
            }
            wreaths += storedSum / 15;
        }
        if (wreaths < 5){
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }else {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        }
    }
}
