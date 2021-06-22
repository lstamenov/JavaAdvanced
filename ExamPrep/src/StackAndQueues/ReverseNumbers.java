package StackAndQueues;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(integers);
        ArrayDeque<Integer> numbers = new ArrayDeque<>(integers);

        while (!numbers.isEmpty()){
            System.out.print(numbers.pop() + " ");
        }
    }
}
