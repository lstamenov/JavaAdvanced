package AdditionalStackAndQueuePractice;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Sedgewick {
    public static void main(String[] args) {
//        1. (Sedgewick, Exercise 4.6).  A letter means push and an asterisk means pop in the
//        following sequence.  Give the sequence of values returned by the pop operations
//        when this sequence of operations is performed on an initially empty LIFO stack.

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Character> chars = new ArrayDeque<>();
        String text = scanner.nextLine();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '*'){
                if (!chars.isEmpty()){
                    chars.pop();
                }
            }else {
                chars.push(text.charAt(i));
            }
        }
    }
}
