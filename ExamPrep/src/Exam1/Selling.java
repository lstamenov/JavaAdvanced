package Exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Selling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        char[][] bakery = new char[n][n];
        for (int i = 0; i < n; i++) {
            String row = reader.readLine();
            for (int j = 0; j < row.length(); j++) {
                bakery[i][j] = row.charAt(j);
            }
        }
        boolean isOutside = false;
        int initialMoney = 0;
        int[] playerPosition = getPlayerPosition(bakery);
        while (initialMoney < 50 && !isOutside){
            String direction = reader.readLine();
            int pRow = playerPosition[0];
            int pCol = playerPosition[1];
            bakery[pRow][pCol] = '-';
            switch (direction){
                case "up":
                    if (pRow > 0){
                        if (bakery[pRow - 1][pCol] == 'O'){
                            bakery[pRow - 1][pCol] = '-';
                            playerPosition = getPillarPosition(bakery);
                            bakery[playerPosition[0]][playerPosition[1]] = 'S';
                        }else if (bakery[pRow - 1][pCol] == '-') {
                            bakery[pRow - 1][pCol] = 'S';
                            playerPosition[0] -= 1;

                        }  else {
                            initialMoney += Integer.parseInt(String.valueOf(bakery[pRow - 1][pCol]));
                            bakery[pRow - 1][pCol] = 'S';
                            playerPosition[0] = pRow - 1;
                            playerPosition[1] = pCol;
                        }
                    }else {
                        isOutside = true;
                    }
                    break;
                case "down":
                    if (pRow < bakery.length - 1){
                        if (bakery[pRow + 1][pCol] == 'O'){
                            bakery[pRow + 1][pCol] = '-';
                            playerPosition = getPillarPosition(bakery);
                            bakery[playerPosition[0]][playerPosition[1]] = 'S';
                        }else if (bakery[pRow + 1][pCol] == '-') {
                            bakery[pRow + 1][pCol] = 'S';
                            playerPosition[0] += 1;

                        } else {
                            initialMoney += Integer.parseInt(String.valueOf(bakery[pRow + 1][pCol]));
                            bakery[pRow + 1][pCol] = 'S';
                            playerPosition[0] = pRow + 1;
                            playerPosition[1] = pCol;
                        }
                    }else {
                        isOutside = true;
                    }
                    break;
                case "right":
                    if (pCol < bakery.length - 1){
                        if (bakery[pRow][pCol + 1] == 'O'){
                            bakery[pRow][pCol + 1] = '-';
                            playerPosition = getPillarPosition(bakery);
                            bakery[playerPosition[0]][playerPosition[1]] = 'S';
                        }else if (bakery[pRow][pCol + 1] == '-') {
                            bakery[pRow][pCol + 1] = 'S';
                            playerPosition[1] += 1;
                        } else {
                            initialMoney += Integer.parseInt(String.valueOf(bakery[pRow][pCol + 1]));
                            bakery[pRow][pCol + 1] = 'S';
                            playerPosition[0] = pRow;
                            playerPosition[1] = pCol + 1;
                        }
                    } else {
                        isOutside = true;
                    }
                    break;
                case "left":
                    if (pCol > 0){
                        if (bakery[pRow][pCol - 1] == 'O'){
                            bakery[pRow][pCol - 1] = '-';
                            playerPosition = getPillarPosition(bakery);
                            bakery[playerPosition[0]][playerPosition[1]] = 'S';
                        }else if (bakery[pRow][pCol - 1] == '-') {
                            bakery[pRow][pCol - 1] = 'S';
                            playerPosition[1] -= 1;

                        } else {
                            initialMoney += Integer.parseInt(String.valueOf(bakery[pRow][pCol - 1]));
                            bakery[pRow][pCol - 1] = 'S';
                            playerPosition[0] = pRow;
                            playerPosition[1] = pCol - 1;
                        }
                    }else {
                        isOutside = true;
                    }
                    break;
            }
        }
        String result = isOutside ? "Bad news, you are out of the bakery." :
                "Good news! You succeeded in collecting enough money!";
        System.out.println(result);
        System.out.println("Money: " + initialMoney);

        for (char[] row : bakery) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }


    private static int[] getPillarPosition(char[][] bakery) {
        int[] position = new int[2];
        for (int i = 0; i < bakery.length; i++) {
            for (int j = 0; j < bakery[i].length; j++) {
                if (bakery[i][j] == 'O'){
                    position = new int[]{i, j};
                    break;
                }
            }
        }
        return position;
    }

    private static int[] getPlayerPosition(char[][] bakery) {
        int[] position = new int[2];
        for (int i = 0; i < bakery.length; i++) {
            for (int j = 0; j < bakery[i].length; j++) {
                if (bakery[i][j] == 'S'){
                    position = new int[]{i, j};
                    break;
                }
            }
        }
        return position;
    }
}
