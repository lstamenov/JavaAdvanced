import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robots = scanner.nextLine().split(";");
        ArrayDeque<String> products = new ArrayDeque<>();
        int[] processTime = new int[robots.length];
        for (int i = 0; i < robots.length; i++) {
            String[] timeString = robots[i].split("-");
            processTime[i] = Integer.parseInt(timeString[1]);
        }
        int[] time = Arrays.stream(scanner.nextLine().split(":"))
                .mapToInt(Integer::parseInt).toArray();
        int[] workingTime = new int[robots.length];
        String input = scanner.nextLine();
        while (!input.equals("End")){
            products.offer(input);
            while (!products.isEmpty()) {
                boolean isWorking = false;
                increaseTime(time);
                for (int i = 0; i < workingTime.length; i++) {
                    if (workingTime[i] == 0 && !isWorking) {
                        workingTime[i] = processTime[i];
                        printData(products.peek(), robots[i], time);
                        isWorking = true;
                    } else if (workingTime[i] > 0){
                        workingTime[i] -= 1;
                    }
                }
                if (isWorking) {
                    products.poll();
                }
            }
            input = scanner.nextLine();
        }

    }

    private static void printData(String peek, String robot, int[] time) {
        String timeAsString = getTimeAsString(time);
        System.out.printf("%s - %s [%s]%n",robot, peek, timeAsString);
    }

    private static String getTimeAsString(int[] time) {
        String timeStr = "";
        for (int i = 0; i < time.length; i++) {
            timeStr += String.valueOf(time[i]);
            if (i < 2){
                timeStr += ":";
            }
        }
        return timeStr;
    }

    private static void increaseTime(int[] time){
        time[2] += 1;
        if (time[2] > 59){
            time[2] = 0;
            time[1] += 1;
            if (time[1] > 59){
                time[1] = 0;
                time[0] += 1;
            }
        }
    }
}
