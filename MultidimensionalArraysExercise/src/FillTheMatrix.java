import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int[][] matrix = new int[rows][rows];
        String pattern = input[1];
        int number = 1;
        if (pattern.equals("A")){
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < rows; j++) {
                        matrix[j][i] = number;
                        number++;
                    }
                }
        }else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < rows; j++) {
                    if (i % 2 == 0){
                        matrix[j][i] = number;
                    }else {
                        matrix[rows - j - 1][i] = number;
                    }
                    number++;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
