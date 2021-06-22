package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            switch (input.charAt(0)) {
                case '2' -> stack.pop();
                case '3' -> System.out.println(getMaximumElement(stack));
                case '1' -> stack.push(Integer.parseInt(input.substring(2)));
            }
        }
    }

    private static int getMaximumElement(ArrayDeque<Integer> stack) {
        int max = Integer.MIN_VALUE;
        for (Integer n : stack) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }
}
