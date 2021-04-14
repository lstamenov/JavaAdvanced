import java.util.Arrays;
import java.util.Scanner;

public class SoftUniParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        int[][] parking = new int[rows][cols];
        String input = scanner.nextLine();
        while (!input.equals("stop")){
            int[] data = Arrays.stream(scanner.nextLine().split("\\s+"))
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
            moves += desiredCol;
            if (parking[desiredRow][desiredCol] == 0){
                parking[desiredRow][desiredCol] = 1;
                System.out.println(moves);
            }else {
                int index = findClosestFreePlace(parking[desiredRow], desiredCol);
                if (index != -1) {
                    if (index > desiredCol)
                        moves += index - desiredCol;
                    else
                        moves += desiredCol - index;
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
        for (int i = desiredCol - 1; i >= 0 ; i++) {
            if (parkingLine[i] == 0){
                break;
            }

        }
        for (int i = desiredCol; i < parkingLine.length; i++) {

        }
        return -1;
    }
}
