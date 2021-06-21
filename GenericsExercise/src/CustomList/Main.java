package CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> list = new CustomList<String>();
        String input = reader.readLine();
        while (!input.equals("END")){
            String[] data = input.split("\\s+");
            switch (data[0]){
                case "Add":
                    list.add(data[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(data[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(data[1]));
                    break;
                case "Swap":
                    int indexF = Integer.parseInt(data[1]);
                    int indexS = Integer.parseInt(data[2]);
                    list.swap(indexF, indexS);
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(data[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.print();
                    break;
                case "Sort":
                    list.sort();
                    break;
            }

            input = reader.readLine();
        }
    }
}
