package StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> currentState = new ArrayDeque<>();
        ArrayDeque<String> lastState = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            switch (input.charAt(0)){
                case '1':
                    if (currentState.size() > 0){
                        String pop = currentState.pop();
                        lastState.push(pop);
                        currentState.push(pop +
                                input.substring(2));
                    }else {
                        currentState.push(input.substring(2));
                    }
                    break;
                case '2':
                    int count = Integer.parseInt(input.substring(2));
                    if (currentState.size() > 0){
                        lastState.push(currentState.peek());
                        String pop = currentState.pop();
                        pop = pop.substring(0, pop.length() - count);
                        currentState.push(pop.length() == 0 ? "" : pop);
                    }
                    break;
                case '3':
                    int index = Integer.parseInt(input.substring(2)) - 1;
                    if (currentState.size() > 0){
                        if (index < currentState.peek().length()){
                            System.out.println(currentState.peek().charAt(index));
                        }
                    }
                    break;
                case '4':
                   if (!lastState.isEmpty()){
                       String pop = currentState.pop();
                       currentState.push(lastState.pop());
                       lastState.push(pop);
                   }
                   break;
            }
        }
    }
}
