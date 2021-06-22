package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] params = scanner.nextLine().split("\\s+");

        int nOffer = Integer.parseInt(params[0]);
        int nPoll = Integer.parseInt(params[1]);
        int number = Integer.parseInt(params[2]);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nOffer; i++) {
            queue.offer(numbers[i]);
        }
        for (int i = 0; i < nPoll; i++) {
            queue.poll();
        }

        boolean isPresent = false;
        int min = Integer.MAX_VALUE;
        for (Integer n : queue) {
            if (n == number){
                isPresent = true;
            }else {
                if (min > n){
                    min = n;
                }
            }
        }

        String result = isPresent ? "true" : String.valueOf(min);
        System.out.println(result);
    }
}
