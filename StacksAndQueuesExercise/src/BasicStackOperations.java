import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] infArr = Arrays.stream((scanner.nextLine().split(" ")))
                .mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream((scanner.nextLine().split(" ")))
                .mapToInt(Integer::parseInt).toArray();
        int numbersToAdd = infArr[0];
        int numbersToRemove = infArr[1];
        int elementToSearch = infArr[2];

        for (int i = 0; i < numbersToAdd; i++) {
            stack.push(numbers[i]);
        }
        for (int i = 0; i < numbersToRemove; i++) {
            stack.pop();
        }
        System.out.println(getElement(stack, elementToSearch));
    }

    private static String getElement(ArrayDeque<Integer> stack, int element) {
        int smallestN = Integer.MAX_VALUE;
        while (!stack.isEmpty()){
            int n = stack.peek();
            if (n < smallestN){
                smallestN = n;
                if (element == n){
                    return "true";
                }
            }
            stack.pop();
        }
        return String.valueOf(smallestN);
    }
}
