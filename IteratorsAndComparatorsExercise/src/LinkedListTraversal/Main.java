package LinkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        TraversaList traversaList = new TraversaList();
        for (int i = 0; i < n; i++) {
            String[] command = reader.readLine().split("\\s+");
            if (command[0].equals("Add")){
                traversaList.add(Integer.parseInt(command[1]));
            }else {
                traversaList.remove(Integer.parseInt(command[1]));
            }
        }
        System.out.println(traversaList.getSize());
        for (int e : traversaList) {
            System.out.print(e + " ");
        }
    }
}
