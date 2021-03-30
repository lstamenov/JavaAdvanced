package Stacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '('){
                arrayDeque.push(i);
            }else if (c == ')'){
                int sIndex = arrayDeque.pop();
                System.out.println(str.substring(sIndex, i + 1));
            }
        }
    }
}
