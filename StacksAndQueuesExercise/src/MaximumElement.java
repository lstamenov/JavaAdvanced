import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (input.length() > 1){
                String[] arr = input.split(" ");
                stack.push(Integer.parseInt(arr[1]));
            }else {
                if (input.equals("3")){
                    System.out.println(printBiggestN(stack));
                }else if (input.equals("2")){
                    stack.pop();
                }
            }
        }
    }

    private static int printBiggestN(ArrayDeque<Integer> stack) {
        ArrayDeque<Integer> bigStack = stack;
        int biggest = Integer.MIN_VALUE;
        while (!bigStack.isEmpty()){
            int n = stack.pop();
            if (n > biggest){
                biggest = n;
            }
        }
        return biggest;
    }
}
