package Stacks;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> calc = new ArrayDeque<>();
        String[] nums = scanner.nextLine().split(" ");
        Collections.addAll(calc, nums);

        while (calc.size() > 1){
            int firstNumber = Integer.parseInt(calc.pop());
            String operator = calc.pop();
            int secondNumber = Integer.parseInt(calc.pop());
            if (operator.equals("+")){
                calc.push(String.valueOf(firstNumber + secondNumber));
            }else {
                calc.push(String.valueOf(firstNumber - secondNumber));
            }
        }

        System.out.println(calc.pop());
    }
}
