package Stacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> binary = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        if (n == 0){
            binary.push(0);
        }
        while (n > 0){
            binary.push(n % 2);
            n /= 2;
        }
        while (!binary.isEmpty()){
            System.out.print(binary.pop());
        }
    }
}
