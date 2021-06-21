import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < size; i++) {
            System.out.print(matrix[i][i] + " " );
        }
        System.out.println();
        for (int rows = 0; rows < size; rows++) {
            System.out.print(matrix[(size - 1) - rows][rows] + " ");
        }
    }
}
