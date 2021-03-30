package Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> printer = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!input.equals("print")){
            if (input.equals("cancel")){
                if (printer.size() > 0) {
                    System.out.println("Canceled " + printer.poll());
                }else {
                    System.out.println("Printer is on standby");
                }
            }else {
                printer.offer(input);
            }
            input = scanner.nextLine();
        }
        while (printer.size() > 0) {
            System.out.println(printer.poll());
        }
    }
}
