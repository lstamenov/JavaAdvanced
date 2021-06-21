package Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] parkingParams = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[][] parking = new int[parkingParams[0]][parkingParams[1]];
        String input = scanner.nextLine();
        while (!input.equals("stop")){
            int[] details = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int enterRow = details[0];
            int desiredRow = details[1];
            int desiredCol = details[2];

            if (isRowFull(parking, desiredRow)){
                System.out.println("Row " + desiredRow + " full");
            }else {
                if (parking[desiredRow][desiredCol] == 0){
                    parking[desiredRow][desiredCol] = 1;
                    System.out.println(getDistance(desiredRow, enterRow, desiredCol));
                }else {
                    int closestRightSpot = getClosestRightSpot(parking, desiredCol, desiredRow);
                    int closestLeftSpot = getClosestLeftSpot(parking, desiredCol, desiredRow);
                    if (closestRightSpot == -1 || closestLeftSpot == -1) {
                        System.out.println(getDistance(desiredRow, enterRow,
                                Math.max(closestLeftSpot, closestRightSpot)));
                        parking[desiredRow][Math.max(closestLeftSpot, closestRightSpot)] = 1;
                    } else {
                        if (Math.abs(desiredCol - closestLeftSpot) >
                                Math.abs(desiredCol - closestRightSpot)) {
                            System.out.println(getDistance(desiredRow, enterRow, closestRightSpot));
                            parking[desiredRow][closestRightSpot] = 1;
                        } else {
                            System.out.println(getDistance(desiredRow, enterRow, closestLeftSpot));
                            parking[desiredRow][closestLeftSpot] = 1;
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
    }

    private static int getDistance(int desiredRow, int enterRow, int desiredCol) {
        return Math.abs(desiredRow - enterRow) + desiredCol + 1;
    }

    private static int getClosestLeftSpot(int[][] parking, int desiredCol, int desiredRow) {
        for (int i = desiredCol; i > 0; i--) {
            if (parking[desiredRow][i] == 0){
                return i;
            }
        }
        return -1;
    }

    private static int getClosestRightSpot(int[][] parking, int desiredCol, int desiredRow) {
        for (int i = desiredCol; i < parking[desiredRow].length; i++) {
            if (parking[desiredRow][i] == 0){
                return i;
            }
        }
        return -1;
    }

    private static boolean isRowFull(int[][] parking, int desiredRow) {
        for (int i = 1; i < parking[desiredRow].length; i++) {
            if (parking[desiredRow][i] == 0){
                return false;
            }
        }
        return true;
    }
}
