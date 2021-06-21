package Matrices;

import java.util.Arrays;
import java.util.Scanner;

public class RadioActiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] groundParams = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        char[][] ground = createGround(groundParams[0], groundParams[1], scanner);
        int[] playerPosition = getPlayerPosition(ground);
        boolean isDead = false;
        boolean isEscaped = false;
        int index = 0;
        String directions = scanner.nextLine();
        while (!isDead && !isEscaped){
            int pRow = playerPosition[0];
            int pCol = playerPosition[1];
            switch (directions.charAt(index++)){
                case 'U':
                    if (pRow - 1 < 0){
                        isEscaped = true;
                    }else {
                        if (ground[pRow - 1][pCol] == '.'){
                            ground[pRow - 1][pCol] = 'P';
                            ground[pRow][pCol] = '.';
                        }else {
                            isDead = true;
                        }
                        playerPosition[0] = pRow - 1;
                    }
                    break;
                case 'D':
                    if (pRow + 1 > ground.length - 1){
                        isEscaped = true;
                    }else {
                        if (ground[pRow + 1][pCol] == '.'){
                            ground[pRow + 1][pCol] = 'P';
                            ground[pRow][pCol] = '.';
                        }else {
                            isDead = true;
                        }
                        playerPosition[0] = pRow + 1;
                    }
                    break;
                case 'R':
                    if (pCol + 1 > ground[pRow].length - 1){
                        isEscaped = true;
                    }else {
                        if (ground[pRow][pCol + 1] == '.'){
                            ground[pRow][pCol + 1] = 'P';
                            ground[pRow][pCol] = '.';
                        }else {
                            isDead = true;
                        }
                        playerPosition[1] = pCol + 1;
                    }
                    break;
                case 'L':
                    if (pCol - 1 < 0){
                        isEscaped = true;
                    }else {
                        if (ground[pRow][pCol - 1] == '.'){
                            ground[pRow][pCol - 1] = 'P';
                            ground[pRow][pCol] = '.';
                        }else {
                            isDead = true;
                        }
                        playerPosition[1] = pCol - 1;
                    }
                    break;
            }
            growBunnies(ground);
            int[] isPlayerFound = getPlayerPosition(ground);
            if (isPlayerFound[0] == -1){
                isDead = true;
            }
        }
        if (isDead){
            System.out.println("dead: " + playerPosition[0] + " " + playerPosition[1]);
        }else {
            System.out.println("won: " + playerPosition[0] + " " + playerPosition[1]);
        }
    }

    private static void growBunnies(char[][] ground) {
        for (int i = 0; i < ground.length; i++) {
            for (int j = 0; j < ground[i].length; j++) {
                if (ground[i][j] == 'B'){
                    if (i - 1 >= 0){
                        ground[i - 1][j] = 'N';
                    }
                    if (i + 1 < ground.length){
                        ground[i + 1][j] = 'N';
                    }

                    if (j - 1 >= 0){
                        ground[i][j - 1] = 'N';
                    }
                    if (j + 1 < ground[i].length){
                        ground[i][j + 1] = 'N';
                    }
                }
            }
        }

        for (int i = 0; i < ground.length; i++) {
            for (int j = 0; j < ground[i].length; j++) {
                if (ground[i][j] == 'N'){
                    ground[i][j] = 'B';
                }
            }
        }
    }

    private static int[] getPlayerPosition(char[][] ground) {
        for (int i = 0; i < ground.length; i++) {
            for (int j = 0; j < ground[i].length; j++) {
                if (ground[i][j] == 'P'){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static char[][] createGround(int rows, int cols, Scanner scanner) {
        char[][] ground = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < cols; j++) {
                ground[i][j] = row.charAt(j);
            }
        }
        return ground;
    }
}
