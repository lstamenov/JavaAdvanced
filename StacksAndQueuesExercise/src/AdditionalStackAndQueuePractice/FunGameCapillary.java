package AdditionalStackAndQueuePractice;

import java.util.ArrayDeque;
import java.util.Scanner;

public class FunGameCapillary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            stack.push(number);
            queue.offer(number);
        }
        while (!stack.isEmpty() && !queue.isEmpty()){
            int stackNumber = stack.peek();
            int queueNumber = queue.peek();
            if (stackNumber > queueNumber){
                System.out.println("2");
                queue.poll();
            }else if (stackNumber < queueNumber){
                System.out.println("1");
                stack.pop();
            }else {
                System.out.println("0");
                stack.pop();
                queue.poll();
            }
        }
    }
}

//    A and B are playing a game. In this game, both of them are initially provided with a list of
//        numbers. (Both have the same list but their own copy).
//        Now, they both have a different strategy to play the game. A
//        picks the element from start of his list.
//        B picks from the end of his list.
//        You need to generate the result in form of an output list.
//        Method to be followed at each step to build the output list is:
//        If the number picked by A
//        is bigger than B then this step's output is 2.
//        removes the number that was picked from their list.
//        If the number picked by A
//        is smaller than B then this step's output is 1.
//        removes the number that was picked from their list.
//        If both have the same number then this step's output is 0
//        . Both A and B remove the number that was picked from their list.
