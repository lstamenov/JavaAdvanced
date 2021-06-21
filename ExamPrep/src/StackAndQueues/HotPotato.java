package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        ArrayDeque<String> children = new ArrayDeque<>();
        for (String name : names) {
            children.offer(name);
        }

        int turn = Integer.parseInt(scanner.nextLine());
        int count = 1;
        while (children.size() > 1){
            if (count % turn == 0){
                System.out.println("Removed " + children.poll());
            }
            count++;
        }
        System.out.println("The last one is " + children.poll());
    }
}
