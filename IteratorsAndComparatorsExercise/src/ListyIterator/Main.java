package ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] data = input.split("\\s+");
        String[] values = new String[data.length - 1];
        System.arraycopy(data, 1, values, 0, data.length - 1);
        ListIterator listIterator = new ListIterator(values);
        Iterator<String> iterator = listIterator.iterator();
        input = reader.readLine();
        while (!input.equals("END")){
            switch (input){
                case "HasNext":
                    System.out.println(iterator.hasNext());
                    break;
                case "Move":
                    System.out.println(listIterator.move());
                    break;
                case "Print":
                    listIterator.print();
                    break;
                case "PrintAll":
                    listIterator.printAll();
                    break;
            }

            input = reader.readLine();
        }
    }
}
