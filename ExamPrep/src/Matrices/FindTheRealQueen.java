package Matrices;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = fillBoard(scanner);

        boolean isFound = false;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'q'){
                    if (areDiagonalsFree(i, j, board) && isRowFree(i, board)
                    && isColumnFree(j, board)){
                        System.out.println(i + " " + j);
                        isFound = true;
                        break;
                    }
                }
            }
            if (isFound){
                break;
            }
        }
    }

    private static boolean isColumnFree(int col, char[][] board) {
        int queenCount = 0;
        for (int k = 0; k < 8; k++) {
            if (board[k][col] == 'q'){
                queenCount++;
            }
        }
        return queenCount == 1;
    }

    private static boolean isRowFree(int row, char[][] board) {
        int queenCount = 0;
        for (int k = 0; k < 8; k++) {
            if (board[row][k] == 'q'){
                queenCount++;
            }
        }
        return queenCount == 1;
    }

    private static boolean areDiagonalsFree(int row, int col, char[][] board) {
        return isLeftDiagonalFree(row, col, board)
                && isRightDiagonalFree(row, col, board);
    }

    private static boolean isRightDiagonalFree(int row, int col, char[][] board) {
        if (row == board.length - 1 || col == board.length - 1){
            return true;
        }else {
            row++;
            col++;
            while (row < board.length && col < board.length){
                if (board[row++][col++] == 'q'){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isLeftDiagonalFree(int row, int col, char[][] board) {
        if (row == 0 || col == 0){
            return true;
        }else {
            row--;
            col--;
            while (row > -1 && col > -1){
                if (board[row--][col--] == 'q'){
                    return false;
                }
            }
        }
        return true;
    }

    private static char[][] fillBoard(Scanner scanner) {
        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String row = scanner.nextLine().replace(" ", "");
            for (int j = 0; j < 8; j++) {
                board[i][j] = row.charAt(j);
            }
        }
        return board;
    }
}
