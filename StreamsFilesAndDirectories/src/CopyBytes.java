import java.io.*;
import java.util.Scanner;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = ("/home/lyubomir/Desktop/folder/input.txt");
        FileInputStream i = new FileInputStream(path);
        Scanner scanner = new Scanner(i);
        FileOutputStream o = new FileOutputStream("output3.txt");
        int nextByte = i.read();
        while (nextByte != -1){
            if (nextByte == ' ' || nextByte == '\n'){
                o.write(nextByte);
            }else {
                o.write(String.valueOf(nextByte).getBytes());
            }
            nextByte = i.read();
        }
        o.close();
    }
}
