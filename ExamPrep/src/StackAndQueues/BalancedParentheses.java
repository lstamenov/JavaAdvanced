package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String parentheses = scanner.nextLine();
        ArrayDeque<Character> sequence = new ArrayDeque<>();

        for (int i = 0; i < parentheses.length(); i++) {
            if (sequence.size() > 0){
                if (sequence.peek() + 1 == parentheses.charAt(i) ||
                        sequence.peek() + 2 == parentheses.charAt(i)){
                    sequence.pop();
                }else {
                    sequence.push(parentheses.charAt(i));
                }
            }else {
                sequence.push(parentheses.charAt(i));
            }
        }
        System.out.println(sequence.size() > 0 ? "NO" : "YES");
    }
}
