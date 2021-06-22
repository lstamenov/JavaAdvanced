package StackAndQueues;

import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> robots = Arrays.asList(scanner.nextLine().split(";"));
        int[] startTime = Arrays.stream(scanner.nextLine().split(":"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<String> robotsQueue = new ArrayDeque<>(robots);
        ArrayDeque<String> products = new ArrayDeque<>();
        Map<String, Integer> robotsWorking = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")){
            increaseTime(startTime);
            reduceOneSecond(robotsWorking);
            List<String> robs = areFreeRobots(robotsWorking);
            if (robs.size() > 0){
                for (String rob : robs) {
                    robotsQueue.offer(rob);
                }
            }
            if (robotsQueue.isEmpty()){
                if (!input.equals("")){
                    products.offer(input);
                }
            } else {
                String product = products.size() > 0 ? products.pop() : input;
                String robot = robotsQueue.poll();
                int robotWorkingTime = Integer.parseInt(robot.substring(robot.indexOf('-') + 1));
                robotsWorking.put(robot, robotWorkingTime);
                System.out.printf("%s - %s [%01d:%02d:%02d]%n", robot, product, startTime[0], startTime[1], startTime[2]);
            }

            if (products.size() == 0) {
                input = scanner.nextLine();
            }else {
                input = "";
            }
        }
    }

    private static void increaseTime(int[] startTime) {
        startTime[2] += 1;
        if (startTime[2] == 60){
            startTime[1] += 1;
            startTime[2] = 0;
        }
        if (startTime[1] == 60){
            startTime[0] += 1;
            startTime[1] = 0;
        }
    }

    private static void reduceOneSecond(Map<String, Integer> robotsWorking) {
        robotsWorking.replaceAll((robot, time) -> time - 1);
    }

    private static List<String> areFreeRobots(Map<String, Integer> robotsWorking) {
        List<String> robs = new ArrayList<>();
        for (Map.Entry<String, Integer> e : robotsWorking.entrySet()) {
            if (e.getValue() == 0){
                robs.add(e.getKey());
                robotsWorking.remove(e.getKey());
            }
        }
        return robs;
    }
}
