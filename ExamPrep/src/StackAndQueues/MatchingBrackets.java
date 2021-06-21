package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        String expression = scanner.nextLine();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '('){
                indexes.push(i);
            }else if (c == ')'){
                System.out.println(expression.substring(indexes.pop(), i + 1));
            }
        }
    }
}

