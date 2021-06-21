import java.util.Arrays;
import java.util.Scanner;

public class SoftUniParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsCol = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = rowsCol[0];
        int cols = rowsCol[1];
        int[][] parking = new int[rows][cols];
        String input = scanner.nextLine();
        while (!input.equals("stop")){
            int[] data = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int entryRow = data[0];
            int desiredRow = data[1];
            int desiredCol = data[2];
            int moves = 0;
            if (entryRow > desiredRow){
                moves += entryRow - desiredRow;
            }else if (entryRow < desiredRow){
                moves += desiredRow - entryRow;
            }
            if (parking[desiredRow][desiredCol] == 0){
                parking[desiredRow][desiredCol] = 1;
                moves += desiredCol + 1;
                System.out.println(moves);
            }else {
                int index = findClosestFreePlace(parking[desiredRow], desiredCol);
                if (index != -1) {
                    parking[desiredRow][index] = 1;
                    if (index > desiredCol)
                        moves += index - desiredCol;
                    else
                        moves += (desiredCol - index) + 1;
                    System.out.println(moves);
                }else {
                    System.out.println("Row + " + desiredRow + " full");
                }
            }
            input = scanner.nextLine();
        }
    }

    private static int findClosestFreePlace(int[] parkingLine, int desiredCol) {
        int leftMoves = 0;
        int rightMoves = 0;
        int[] moves = new int[2];
        for (int i = desiredCol - 1; i >= 0 ; i--) {
            leftMoves++;
            if (parkingLine[i] == 0){
                moves[0] = i;
                break;
            }
        }
        for (int i = desiredCol + 1; i < parkingLine.length; i++) {
            rightMoves++;
            if (parkingLine[i] == 0){
                moves[1] = i;
                break;
            }
        }
        
        if (leftMoves == 0 && rightMoves == 0){
            return -1;
        }else {
            if (leftMoves == 0){
                return moves[1];
            }else if (rightMoves == 0){
                return moves[0];
            }else {
                if (leftMoves < rightMoves)
                    return moves[0];
                else if (rightMoves < leftMoves)
                    return moves[1];
                else 
                    return moves[0];
            }
        }
    }
}
