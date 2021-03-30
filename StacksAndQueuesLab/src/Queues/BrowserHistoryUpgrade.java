package Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> back = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!input.equals("Home")){
            if (input.equals("forward")){
                if (forward.size() < 1){
                    System.out.println("no next URLs");
                }else {
                    System.out.println(forward.peek());
                    back.push(forward.poll());
                }
            }else if (input.equals("back")){
                if (back.size() >= 2){
                    forward.offer(back.pop());
                    System.out.println(back.peek());
                }
            }else {
                back.push(input);
                System.out.println(input);
            }
            input = scanner.nextLine();
        }
    }
}
