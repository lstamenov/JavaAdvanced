package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        ArrayDeque<String> children = new ArrayDeque<>();
        for (String name : names) {
            children.offer(name);
        }

        int count = 1;
        while (children.size() > 1){
            if (isComposite(count)){
                System.out.println("Removed " + children.poll());
            }else {
                System.out.println("Prime " + children.peekFirst());
                children.offer(children.poll());
            }
            count++;
        }
        System.out.println("The last one is " + children.poll());
    }

    private static boolean isComposite(int count) {
        for (int i = 2; i < count; i++) {
            if (count % i == 0){
                return true;
            }
        }
        return false;
    }
}
