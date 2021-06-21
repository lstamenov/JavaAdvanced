import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        stack.push(1);
        int n = Integer.parseInt(scanner.nextLine());
        int count = 1;
        System.out.println(getNumber(stack, n, count));
    }

    private static int getNumber(ArrayDeque<Integer> stack, int n, int count) {
        int last = stack.pop();
        int number = stack.pop() + last;
        stack.push(last);
        stack.push(number);
        if (count < n){
            return getNumber(stack, n -1, count);
        }else {
            return number;
        }
    }
}
