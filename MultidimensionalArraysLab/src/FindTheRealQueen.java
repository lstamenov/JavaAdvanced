
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] chessField = new char[8][8];
        for (int i = 0; i < 8; i++) {
            chessField[i] = getCharArray(scanner.nextLine());
        }
        boolean isFound = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessField[i][j] == 'q')
                    if (findRow(i, j, chessField) && findCol(i, j, chessField) && findDiagonal(i, j, chessField)) {
                        System.out.println(i + " " + j);
                        isFound = true;
                        break;
                    }
            }
            if (isFound){
                break;
            }
        }
    }

    private static boolean findDiagonal(int i, int j, char[][] chessField) {
        int startingRow = i;
        int startingCol = j;
        while (startingCol > 0){
            startingCol--;
            startingRow--;
        }
        while (startingRow < 8){
            if (chessField[startingRow][startingCol] == 'q' && startingRow != i){
                return false;
            }
            startingRow++;
            startingCol++;
        }
        return true;
    }

    private static boolean findCol(int i, int j, char[][] chessField) {
        for (int k = 0; k < 8; k++) {
            if (chessField[k][j] == 'q' && k != i){
                return false;
            }
        }
        return true;
    }

    private static boolean findRow(int i, int j, char[][] chessField) {
        for (int k = 0; k < 8; k++) {
            if (chessField[i][k] == 'q' && k != j){
                return false;
            }
        }
        return true;
    }

    private static char[] getCharArray(String nextLine) {
        char[] arr = new char[8];
        int count = 0;
        for (int i = 0; i < nextLine.length(); i++) {
            if (nextLine.charAt(i) != ' '){
                arr[count] = nextLine.charAt(i);
                count++;
            }
        }
        return arr;
    }
}
