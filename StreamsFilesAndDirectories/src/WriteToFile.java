import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "/home/lyubomir/Desktop/folder/input.txt";
        FileInputStream fileInputStream = new FileInputStream(path);
        FileOutputStream fileOutputStream = new FileOutputStream("output2.txt");
        String table = ",.?!";
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            for (int i = 0; i < s.length(); i++) {
                char sym = s.charAt(i);
                if (!table.contains(String.valueOf(sym))){
                    fileOutputStream.write(sym);
                }
            }
            fileOutputStream.write('\n');
        }
    }
}
