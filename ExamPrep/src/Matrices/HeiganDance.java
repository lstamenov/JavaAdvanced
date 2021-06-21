package Matrices;

import java.util.Scanner;

public class HeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[15][15];
        int playerHealth = 18500;
        int heiganHealth = 3000000;
        int playerDamage = Integer.parseInt(scanner.nextLine());
        boolean isCloudActivated = false;
        int[] playerPosition = {7, 7};
        String input = scanner.nextLine();
        while (playerHealth > 0 && heiganHealth > 0) {
            heiganHealth -= playerDamage;
            String[] command = input.split("\\s+");
            int damageRow = Integer.parseInt(command[1]);
            int damageCol = Integer.parseInt(command[2]);
            takeDamage(board, damageRow, damageCol);
            if (board[playerPosition[0]][playerPosition[1]] == 1) {
                if (isUpFree(playerPosition, board)) {
                    playerPosition[0] -= 1;
                } else {
                    if (isRightFree(playerPosition, board)) {
                        playerPosition[1] += 1;
                    } else {
                        if (isDownFree(playerPosition, board)) {
                            playerPosition[0] += 1;
                        } else {
                            if (isLeftFree(playerPosition, board)) {
                                playerPosition[1] -= 1;
                            } else {
                                if (isCloudActivated) {
                                    playerHealth -= 3500;
                                    isCloudActivated = false;
                                }
                                if (command[0].equals("Cloud")) {
                                    playerHealth -= 3500;
                                    isCloudActivated = true;
                                } else {
                                    playerHealth -= 6000;
                                }
                            }
                        }
                    }
                }
            }
            board = new int[15][15];
            if (playerHealth > 0 && heiganHealth > 0) {
                input = scanner.nextLine();
            }else {
                break;
            }
        }
        if (heiganHealth > 0) {
            System.out.printf("Heigan: %d%n", heiganHealth);
            System.out.printf("Player: Killed by %s%n", input.substring(0, input.length() - 4));
            System.out.printf("Final position: %d, %d", playerPosition[0], playerPosition[1]);
        }else {
            System.out.println("Heigan: Defeated!");
            System.out.printf("Player: %d%n", playerHealth);
            System.out.printf("Final position: %d, %d", playerPosition[0], playerPosition[1]);
        }
    }

    private static boolean isLeftFree(int[] playerPosition, int[][] board) {
        int pRow = playerPosition[0];
        int pCol = playerPosition[1];

        if (pCol > 0){
            return board[pRow][pCol - 1] == 0;
        }else {
            return false;
        }
    }

    private static boolean isDownFree(int[] playerPosition, int[][] board) {
        int pRow = playerPosition[0];
        int pCol = playerPosition[1];

        if (pRow < board.length - 1){
            return board[pRow + 1][pCol] == 0;
        }else {
            return false;
        }
    }

    private static boolean isRightFree(int[] playerPosition, int[][] board) {
        int pRow = playerPosition[0];
        int pCol = playerPosition[1];

        if (pCol < board.length -  1){
            return board[pRow][pCol + 1] == 0;
        }else {
            return false;
        }
    }

    private static boolean isUpFree(int[] playerPosition, int[][] board) {
        int pRow = playerPosition[0];
        int pCol = playerPosition[1];

        if (pRow > 0){
            return board[pRow - 1][pCol] == 0;
        }else {
            return false;
        }
    }

    private static void takeDamage(int[][] board, int row, int col) {
        board[row][col] = 1;
        if (row > 0){
            board[row - 1][col] = 1;
        }
        if (row < board.length - 1){
            board[row + 1][col] = 1;
        }

        if (col > 0){
            board[row][col - 1] = 1;
        }
        if (col < board[row].length - 1){
            board[row][col  + 1] = 1;
        }

        if (row > 0 && col > 0){
            board[row - 1][col - 1] = 1;
        }
        if (row < board.length - 1 && col < board.length - 1){
            board[row + 1][col + 1] = 1;
        }

        if (row < board.length - 1 && col > 0){
            board[row + 1][col - 1] = 1;
        }
        if (row > 0 && col < board.length - 1){
            board[row - 1][col + 1] = 1;
        }
    }
}
