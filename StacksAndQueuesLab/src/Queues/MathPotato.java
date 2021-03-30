package Queues;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] arr = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        for (String a : arr) {
            queue.offer(a);
        }
        int cycle = 1;
        while (queue.size() > 1){
            for (int i = 1; i < n; i++) {
                queue.offer(Objects.requireNonNull(queue.poll()));
            }
            if (!isPrime(cycle)){
                System.out.println("Removed " + queue.poll());
            }
            cycle++;

        }
        System.out.println("Last is " + queue.poll());
    }
    private static boolean isPrime(int n){
        for (int i = 2; i <= n / 2; i++) {
            if (n % 2 == 0){
                return false;
            }
        }
        return true;
    }
}
