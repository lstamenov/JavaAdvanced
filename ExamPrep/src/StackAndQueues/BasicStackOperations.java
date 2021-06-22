package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] params = scanner.nextLine().split("\\s+");

        int nPush = Integer.parseInt(params[0]);
        int nPop = Integer.parseInt(params[1]);
        int nIsPresent = Integer.parseInt(params[2]);

        ArrayDeque<Integer> nums = new ArrayDeque<>();
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < nPush; i++) {
            nums.push(numbers[i]);
        }

        for (int i = 0; i < nPop; i++) {
            nums.pop();
        }

        boolean isPresent = false;
        int smallestNumber = Integer.MAX_VALUE;
        for (Integer n : nums) {
            if (n == nIsPresent){
                isPresent = true;
            }else {
                if (n < smallestNumber){
                    smallestNumber = n;
                }
            }
        }
        String result =  isPresent ? "true" : String.valueOf(smallestNumber);
        System.out.println(result);
    }
}
