import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/lyubomir/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("outputLineNumbers.txt"));
        int count = 1;
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            String newLine = String.format("%d. ", count);
            newLine += line;
            bufferedWriter.write(newLine);
            bufferedWriter.newLine();
            count++;
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
