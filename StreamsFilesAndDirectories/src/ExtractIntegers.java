import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String path = ("/home/lyubomir/Desktop/folder/input.txt");
        FileInputStream fileInputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(fileInputStream);
        PrintWriter printWriter = new PrintWriter("output3.txt");
        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                int number = scanner.nextInt();
                printWriter.println(number);
            }
            scanner.next();
        }
        printWriter.flush();
    }
}
