package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> calc = new ArrayDeque<>();
        String[] operations = scanner.nextLine().split("\\s+");
        calc.push(Integer.parseInt(operations[0]));
        for (int i = 1; i < operations.length; i++) {
            if (operations[i].equals("+")){
                calc.push(calc.pop() + Integer.parseInt(operations[i + 1]));
            }else {
                calc.push(calc.pop() - Integer.parseInt(operations[i + 1]));
            }
            i++;
        }
        System.out.println(calc.pop());
    }
}
