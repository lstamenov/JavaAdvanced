package AdditionalStackAndQueuePractice;

import java.util.ArrayDeque;
import java.util.Scanner;

public class FinancialProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] values = new int[days];
        for (int i = 0; i < days; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            queue.offer(n);
            values[i] = n;
        }
        int count = 0;
        while (!queue.isEmpty()){
            int daysCount = 1;
            int n = queue.poll();
            ArrayDeque<Integer> stack = getLeftDays(count, values);
            while (!stack.isEmpty()){
                if (n >= stack.pop()){
                    daysCount++;
                }else {
                    break;
                }
            }
            System.out.println(daysCount);
            count++;
        }
    }

    private static ArrayDeque<Integer> getLeftDays(int count, int[] values) {
        ArrayDeque<Integer> integers = new ArrayDeque<>();
        for (int i = 0; i < count; i++) {
            integers.push(values[i]);
        }
        return integers;
    }
}

//During this COVID19 outbreak, the gold price are very much unstable. Raja Indraverma is
//        very much tensed. He has asked Bheem to analyse the gold price rate.
//        Now Bheem is given a report of N consicutive days contaning gold price of those
//        N consicutive days. Bheem has to check for how many days (including the ith day)
//        the ith price was greater than or equal to its previous consicutive days. He will
//        report the final result for each given N days.First line of each test
//        case contains an integer N denoting number of days for which Bheem has to analyse
//        Output For each test case print N space separated integers denoting the analysis the report.
