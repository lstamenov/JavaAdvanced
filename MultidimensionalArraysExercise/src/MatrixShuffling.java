import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[] data = input.split("\\s+");
            String swap = data[0];
            if (swap.equals("swap") && data.length == 5){
                try {
                    int[] fDimensions = {Integer.parseInt(data[1]), Integer.parseInt(data[2])};
                    int[] sDimensions = {Integer.parseInt(data[3]), Integer.parseInt(data[4])};
                    int temp = matrix[fDimensions[0]][fDimensions[1]];
                    matrix[fDimensions[0]][fDimensions[1]] = matrix[sDimensions[0]][sDimensions[1]];
                    matrix[sDimensions[0]][sDimensions[1]] = temp;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                }catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
                    System.out.println("Invalid input!");
                }
            }else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }
}
