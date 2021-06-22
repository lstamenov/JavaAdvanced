package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        numbers.push(1);
        numbers.push(1);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i < n; i++) {
            int first = numbers.pop();
            Integer second = numbers.pop();
            numbers.push(first);
            numbers.push(first + second);
        }
        System.out.println(numbers.peek());
    }
}
