import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateTxtFiles {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter("/home/lyubomir/Desktop/txt1.txt"));
        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("/home/lyubomir/Desktop/txt2.txt"));
        BufferedWriter bufferedWriter3 = new BufferedWriter(new FileWriter("/home/lyubomir/Desktop/txt3.txt"));
        bufferedWriter1.write("");
        bufferedWriter2.write("");
        bufferedWriter3.write("");
        bufferedWriter1.close();
        bufferedWriter2.close();
        bufferedWriter3.close();
    }
}
