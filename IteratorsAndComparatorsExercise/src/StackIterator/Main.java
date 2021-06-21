package StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) throws IOException {
        StackIterable stackIterable = new StackIterable();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        while (!input.equals("END")){
            if (input.contains("Push")){
                String newInput = input.substring(5);
                String[] arr = newInput.split("[, ]+");
                int[] nums = new int[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    nums[i] = Integer.parseInt(arr[i]);
                }
                stackIterable.push(nums);
            }else {
                stackIterable.pop();
            }

            input = reader.readLine();
        }
        Iterator<Integer> iterator = stackIterable.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Iterator<Integer> iterator2 = stackIterable.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
