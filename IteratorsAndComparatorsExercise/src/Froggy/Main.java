package Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        while (!input.equals("END")){
            int[] arr = Arrays.stream(input.split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            Lake lake = new Lake(arr);
            Iterator<Integer> iterator = lake.iterator();
            while (iterator.hasNext()){
                int n = iterator.next();
                if (iterator.hasNext()){
                    System.out.print(n + ", ");
                }else {
                    System.out.print(n);
                }
            }

            input = reader.readLine();
        }
    }
}
