import javax.swing.*;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> string = new ArrayDeque<>();
        ArrayDeque<String> lastString = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]){
                case "1":
                    if (string.isEmpty()){
                        string.push(command[1]);
                        lastString.push("");
                    }else {
                        lastString.push(string.peek());
                        string.push(string.pop() + command[1]);
                    }
                    break;
                case "2":
                    int count = Integer.parseInt(command[1]);
                    String newString = "";
                    String currString = string.pop();
                    lastString.push(currString);
                    for (int j = 0; j < currString.length() - count; j++) {
                        newString += currString.charAt(j);
                    }
                    string.push(newString);
                    break;
                case "3":
                    int index = Integer.parseInt(command[1]);
                    assert string.peek() != null;
                    System.out.println(string.peek().charAt(index - 1));
                    break;
                case "4":
                    string.pop();
                    string.push(lastString.pop());
                    break;
            }
        }
    }
}
