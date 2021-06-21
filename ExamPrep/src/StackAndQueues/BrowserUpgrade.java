package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> forwardPages = new ArrayDeque<>();
        ArrayDeque<String> backPages = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!input.equals("Home")){
            if (input.equals("forward")){
                if (!forwardPages.isEmpty()){
                    String url = forwardPages.pop();
                    System.out.println(url);
                    backPages.push(url);
                }else {
                    System.out.println("No next URLs");
                }
            }else if (input.equals("back")){
                if (backPages.size() > 1){
                    forwardPages.push(backPages.pop());
                    System.out.println(backPages.peek());
                }else {
                    System.out.println("No next URLs");
                }
            }else {
                backPages.push(input);
                System.out.println(input);
            }
            input = scanner.nextLine();
        }
    }
}
