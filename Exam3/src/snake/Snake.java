package snake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        char[][] field = new char[n][];
        for (int i = 0; i < n; i++) {
            field[i] = reader.readLine().toCharArray();
        }
        int foodEaten = 0;
        boolean isInside = true;
        while (foodEaten < 10 && isInside){
            String direction = reader.readLine();
            int[] snakePosition = getSnakePosition(field);
            switch (direction){
                case "up":
                    if (snakePosition[0] > 0) {
                        foodEaten += moveSnake(-1, 0, field);
                    }else {
                        isInside = false;
                        field[snakePosition[0]][snakePosition[1]] = '.';
                    }
                    break;
                case "right":
                    if (snakePosition[1] < field.length - 1) {
                        foodEaten += moveSnake(0, 1, field);
                    }else {
                        isInside = false;
                        field[snakePosition[0]][snakePosition[1]] = '.';
                    }
                    break;
                case "down":
                    if (snakePosition[0] < field.length - 1) {
                        foodEaten += moveSnake(1, 0, field);
                    }else {
                        isInside = false;
                        field[snakePosition[0]][snakePosition[1]] = '.';
                    }
                    break;
                case "left":
                    if (snakePosition[1] > 0) {
                        foodEaten += moveSnake(0, -1, field);
                    }else {
                        isInside = false;
                        field[snakePosition[0]][snakePosition[1]] = '.';
                    }
                    break;
            }
        }
        String result = isInside ? "You won! You fed the snake." : "Game over!";
        System.out.println(result);
        System.out.println("Food eaten: " + foodEaten);
        for (char[] r : field) {
            for (char c : r) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static int moveSnake(int rowModifier, int colModifier, char[][] field) {
        int foodEaten = 0;

        int[] snakePosition = getSnakePosition(field);
        int snakeRow = snakePosition[0];
        int snakeCol = snakePosition[1];
        field[snakeRow][snakeCol] = '.';
        //last place is free
        snakeRow += rowModifier;
        snakeCol += colModifier;
        //setting new cordinates

        if (field[snakeRow][snakeCol] == 'B'){
            field[snakeRow][snakeCol] = '.';
            //setting first burrow pos to free
            int[] burrowPosition = getBurrowPosition(field);
            snakeRow = burrowPosition[0];
            snakeCol = burrowPosition[1];
            //setting first burrow pos to snake
        }else {
            if (field[snakeRow][snakeCol] == '*'){
                foodEaten = 1;
            }
        }
        field[snakeRow][snakeCol] = 'S';
        return foodEaten;
    }

    private static int[] getBurrowPosition(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 'B'){
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    private static int[] getSnakePosition(char[][] field) {
        int[] pos = new int[2];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'S'){
                    pos = new int[]{i, j};
                    break;
                }
            }
        }
        return pos;
    }
}
