package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Printer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> printer = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!input.equals("print")){
            if (input.equals("cancel")){
                if (printer.isEmpty()){
                    System.out.println("Printer is on standby");
                }else {
                    System.out.println("Canceled " + printer.poll());
                }
            }else {
                printer.offer(input);
            }

            input = scanner.nextLine();
        }

        while (!printer.isEmpty()){
            System.out.println(printer.poll());
        }
    }
}
