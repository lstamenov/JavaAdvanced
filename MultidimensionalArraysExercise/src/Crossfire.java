import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int count = 1;
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = count;
                count++;
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")){
            String[] numbers = input.split("\\s+");
            int row = Integer.parseInt(numbers[0]);
            int col = Integer.parseInt(numbers[1]);
            int radius = Integer.parseInt(numbers[2]);
            destroyCol(col, row, radius, matrix);
            input = scanner.nextLine();
        }

        for (int[] a : matrix) {
            for (int n : a) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static void destroyCol(int col, int row, int radius, int[][] matrix) {
        int start = row - radius;
        int end = radius + row;
        if (start < 0){
            start = 0;
        }
        if (end > matrix.length) {
            end = matrix.length;
        }
            for (int i = start; i < end; i++) {
                if (i == row){
                    int rowStart = col - radius;
                    int rowEnd = col + radius;
                    if (rowStart < 0){
                        rowStart = 0;
                    }
                    if (rowEnd > matrix.length){
                        rowEnd = matrix.length;
                    }
                    int[] newArr = new int[getLength(matrix.length, rowStart, rowEnd)];
                    int index = 0;
                    for (int j = 0; j < matrix[i].length; j++) {
                        if (j < rowStart || j > rowEnd){
                            newArr[index] = matrix[i][j];
                        }
                        index++;
                    }
                    matrix[i] = newArr;
                }else {
                    boolean isChanged = false;
                    int[] newArr = new int[matrix[i].length - 1];
                    for (int j = 0; j < newArr.length; j++) {
                        if (j == col || j > col) {
                            newArr[j] = matrix[i][j + 1];
                        } else {
                            newArr[j] = matrix[i][j];
                        }
                        isChanged = true;
                    }
                    if (isChanged)
                        matrix[i] = newArr;
                }
            }

    }

    private static int getLength(int length, int rowStart, int rowEnd) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (i < rowStart || i > rowEnd)
                count++;
        }
        return count;
    }
}
