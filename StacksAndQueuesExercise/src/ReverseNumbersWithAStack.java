import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> reversed = new ArrayDeque<>();
        for (int n : arr) {
            reversed.push(n);
        }
        while (!reversed.isEmpty()){
            System.out.print(reversed.pop() + " ");
        }
    }
}
