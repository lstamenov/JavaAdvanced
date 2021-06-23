package bee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bee {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        char[][] territory = new char[n][n];
        fillTerritory(territory, reader);
        int[] beePosition = getBeePosition(territory);

        int polinationedFlowers = 0;
        String input = reader.readLine();
        boolean isOutside = false;
        while (!input.equals("End") && !isOutside){
            int beeRow = beePosition[0];
            int beeCol = beePosition[1];

            territory[beeRow][beeCol] = '.';

            switch (input){
                case "up":
                    if (beeRow > 0){
                        beeRow -= 1;
                        if (territory[beeRow][beeCol] == 'O'){
                            territory[beeRow][beeCol] = '.';
                            beeRow--;
                            if (territory[beeRow][beeCol] == 'f'){
                                polinationedFlowers += 1;
                            }
                            territory[beeRow][beeCol] = 'B';
                            beePosition[0] = beeRow;
                        }else if (territory[beeRow][beeCol] == 'f'){
                            polinationedFlowers++;
                            territory[beeRow][beeCol] = 'B';
                            beePosition[0] = beeRow;
                        } else {
                            beePosition[0] = beeRow;
                            territory[beeRow][beeCol] = 'B';
                        }
                    }else {
                        isOutside = true;
                    }
                    break;
                case "down":
                    if (beeRow < territory.length - 1){
                        beeRow += 1;
                        if (territory[beeRow][beeCol] == 'O'){
                            territory[beeRow][beeCol] = '.';
                            beeRow++;
                            if (territory[beeRow][beeCol] == 'f'){
                                polinationedFlowers += 1;
                            }
                            territory[beeRow][beeCol] = 'B';
                            beePosition[0] = beeRow;
                        }else if (territory[beeRow][beeCol] == 'f'){
                            polinationedFlowers++;
                            territory[beeRow][beeCol] = 'B';
                            beePosition[0] = beeRow;
                        }else {
                            beePosition[0] = beeRow;
                            territory[beeRow][beeCol] = 'B';
                        }
                    }else {
                        isOutside = true;
                    }
                    break;
                case "right":
                    if (beeCol < territory.length - 1){
                        beeCol += 1;
                        if (territory[beeRow][beeCol] == 'O'){
                            territory[beeRow][beeCol] = '.';
                            beeCol++;
                            if (territory[beeRow][beeCol] == 'f'){
                                polinationedFlowers += 1;
                            }
                            territory[beeRow][beeCol] = 'B';
                            beePosition[1] = beeCol;
                        }else if (territory[beeRow][beeCol] == 'f'){
                            polinationedFlowers++;
                            territory[beeRow][beeCol] = 'B';
                            beePosition[1] = beeCol;
                        }else {
                            beePosition[1] = beeCol;
                            territory[beeRow][beeCol] = 'B';
                        }
                    }else {
                        isOutside = true;
                    }
                    break;
                case "left":
                    if (beeCol > 0){
                        beeCol -= 1;
                        if (territory[beeRow][beeCol] == 'O'){
                            territory[beeRow][beeCol] = '.';
                            beeCol--;
                            if (territory[beeRow][beeCol] == 'f'){
                                polinationedFlowers += 1;
                            }
                            territory[beeRow][beeCol] = 'B';
                            beePosition[1] = beeCol;
                        }else if (territory[beeRow][beeCol] == 'f'){
                            polinationedFlowers++;
                            territory[beeRow][beeCol] = 'B';
                            beePosition[1] = beeCol;
                        }else {
                            beePosition[1] = beeCol;
                            territory[beeRow][beeCol] = 'B';
                        }
                    }else {
                        isOutside = true;
                    }
                    break;
            }

            if (!isOutside) {
                input = reader.readLine();
            }
        }
        if (isOutside){
            System.out.println("The bee got lost!");
        }
        if (polinationedFlowers > 5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", polinationedFlowers);
        }else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - polinationedFlowers);
        }
        for (char[] row : territory) {
            for (char r : row) {
                System.out.print(r);
            }
            System.out.println();
        }
    }

    private static int[] getBeePosition(char[][] territory) {
        int[] position = new int[2];
        for (int i = 0; i < territory.length; i++) {
            for (int j = 0; j < territory[i].length; j++) {
                if (territory[i][j] == 'B'){
                    position = new int[]{i, j};
                }
            }
        }
        return position;
    }

    private static void fillTerritory(char[][] territory, BufferedReader reader) throws IOException {
        for (int i = 0; i < territory.length; i++) {
            String row = reader.readLine();
            for (int j = 0; j < row.length(); j++) {
                territory[i][j] = row.charAt(j);
            }
        }
    }
}
