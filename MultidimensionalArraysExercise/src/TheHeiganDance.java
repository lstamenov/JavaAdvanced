import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] chamber = new int[15][15];
        double heiganHealth = 3000000;
        double playerHealth = 18500;
        int[] playerPosition = {7, 7};
        String lastSpell = "";
        double playerDamage = Double.parseDouble(scanner.nextLine());
        while (playerHealth > 0 && heiganHealth > 0){
            boolean isMove = false;
            String[] spellData = scanner.nextLine().split("\\s+");
            String spellName = spellData[0];
            int row = Integer.parseInt(spellData[1]);
            int col = Integer.parseInt(spellData[2]);
            heiganHealth -= playerDamage;
            chamber[row][col] = 1;
            if (isInTheChamber(row -1, col)){
                chamber[row - 1][col] = 1;
            }
            if (isInTheChamber(row + 1, col)){
                chamber[row + 1][col] = 1;
            }
            if (isInTheChamber(row, col - 1)){
                chamber[row][col - 1] = 1;
            }
            if (isInTheChamber(row, col + 1)){
                chamber[row][col + 1] = 1;
            }
                if (chamber[playerPosition[0]][playerPosition[1]] == 1) {
                    if (getPlayerPosition("up", chamber, playerPosition[0], playerPosition[1]) != 1
                            && getPlayerPosition("up", chamber, playerPosition[0], playerPosition[1]) != -1) {
                        playerPosition[0] = playerPosition[0] - 1;
                        isMove = true;
                    } else if (getPlayerPosition("right", chamber, playerPosition[0], playerPosition[1]) != 1
                            && getPlayerPosition("right", chamber, playerPosition[0], playerPosition[1]) != -1) {
                        playerPosition[1] = playerPosition[1] + 1;
                        isMove = true;
                    } else if (getPlayerPosition("down", chamber, playerPosition[0], playerPosition[1]) != 1
                            && getPlayerPosition("down", chamber, playerPosition[0], playerPosition[1]) != -1) {
                        playerPosition[0] = playerPosition[0] + 1;
                        isMove = true;
                    } else if (getPlayerPosition("left", chamber, playerPosition[0], playerPosition[1]) != 1
                            && getPlayerPosition("left", chamber, playerPosition[0], playerPosition[1]) != -1) {
                        playerPosition[1] = playerPosition[1] - 1;
                        isMove = true;
                    }
            }
            if ((row == playerPosition[0] && col == playerPosition[1]) || !isMove) {
                if (lastSpell.equals("Cloud")){
                    playerHealth -= 3500;
                }
                if (spellName.equals("Cloud")){
                    playerHealth -= 3500;
                }else {
                    playerHealth -= 6000;
                }
                lastSpell = spellName;
            }
            chamber = new int[15][15];
        }
        if (heiganHealth < 1){
            System.out.println("Heigan: Defeated!");
        }else {
            System.out.printf("Heigan: %.2f%n", heiganHealth);
        }
        if (playerHealth < 1){
            System.out.println("Player killed by " + lastSpell);
        }else {
            System.out.printf("{Player: %.2f%n", playerHealth);
        }
        System.out.println("Final position: " + playerPosition[0] + ", " + playerPosition[1]);
    }

    private static int getPlayerPosition(String direction, int[][] chamber, int row, int col) {
        switch (direction){
            case "up":
                if (isInTheChamber(row + 1, col))
                    return chamber[row + 1][col];
                break;
            case "right":
                if (isInTheChamber(row, col + 1))
                    return chamber[row + 1][col + 1];
                break;
            case "down":
                if (isInTheChamber(row - 1, col))
                    return chamber[row - 1][col];
                break;
            case "left":
                if (isInTheChamber(row, col - 1))
                    return chamber[row][col - 1];
                break;
        }
        return -1;
    }

    private static boolean isInTheChamber(int row, int col) {
        return  (row >= 0 && row < 15 && col >= 0 && col < 15);
    }
}
