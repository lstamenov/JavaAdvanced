package Queues;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] arr = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        for (String a : arr) {
            queue.offer(a);
        }
        while (queue.size() > 1){
            for (int i = 1; i < n; i++) {
                queue.offer(Objects.requireNonNull(queue.poll()));

                System.out.println("Removed " + queue.poll());
            }
        }
        System.out.println("The last is " + queue.poll());
    }
}
