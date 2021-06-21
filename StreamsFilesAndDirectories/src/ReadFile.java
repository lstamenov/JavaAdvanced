import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "/home/lyubomir/Desktop/folder/input.txt";
        FileInputStream f = new FileInputStream(path);
        int oneByte = f.read();
        while (oneByte >= 0){
            System.out.printf("%s ", Integer.toBinaryString(oneByte));
            oneByte = f.read();
        }
    }
}
