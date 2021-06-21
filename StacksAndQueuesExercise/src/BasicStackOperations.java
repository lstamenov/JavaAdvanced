import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] variables = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = variables[0];
        int s = variables[1];
        int x = variables[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        for (int num : numbers) {
            stack.push(num);
        }
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        if (isSuchElement(stack, x)){
            System.out.println("true");
        }else {
            int smallestN = Integer.MAX_VALUE;
            while (!stack.isEmpty()){
                int num = stack.pop();
                if (num < smallestN)
                    smallestN = num;
            }
            System.out.println(smallestN);
        }
    }

    private static boolean isSuchElement(ArrayDeque<Integer> stack, int x) {
        for (int n : stack) {
            if (n == x){
                return true;
            }
        }
        return false;
    }
}
