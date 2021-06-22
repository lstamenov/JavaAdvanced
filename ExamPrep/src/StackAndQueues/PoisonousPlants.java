package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stackPlants = new ArrayDeque<>();
        ArrayDeque<Integer> queuePlants = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        int[] pesticides = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < n; i++) {
            stackPlants.push(pesticides[i]);
        }

        int days = 0;
        boolean havePlantsDied = true;
        while (havePlantsDied){
            int currentPlantsSize = stackPlants.size();
            while (!stackPlants.isEmpty()){
                int lastPantPesticides = stackPlants.pop();
                    if (stackPlants.size() == 0){
                        queuePlants.push(lastPantPesticides);
                    }else {
                        if (lastPantPesticides < stackPlants.peek()) {
                            queuePlants.push(lastPantPesticides);
                        }
                    }
            }
            if (currentPlantsSize == queuePlants.size()){
                havePlantsDied = false;
            }else {
                while (!queuePlants.isEmpty()){
                    stackPlants.push(queuePlants.pop());
                }
                queuePlants = new ArrayDeque<>();
            }
            days++;
        }
        System.out.println(days - 1);
    }
}
