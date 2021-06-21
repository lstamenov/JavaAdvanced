import java.io.*;

public class SumLines {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/lyubomir/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
        while (bufferedReader.ready()){
            String s = bufferedReader.readLine();
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += s.charAt(i);
            }
            String sm = String.valueOf(sum);
            System.out.println(sm);
        }
        bufferedReader.close();
    }
//    /home/lyubomir/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt
}
