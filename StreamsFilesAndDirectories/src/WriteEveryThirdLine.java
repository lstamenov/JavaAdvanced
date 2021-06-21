import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("outputPath.txt");
        PrintWriter printWriter = new PrintWriter(new FileWriter(String.valueOf(path)));
        Path inputPath = Paths.get("/home/lyubomir/Desktop/folder/input.txt");
        List<String> lines = Files.readAllLines(inputPath);
        for (int i = 0; i < lines.size(); i++) {
            if (i % 3 == 0 && i != 0){
                printWriter.println(lines.get(i));
            }
        }
        printWriter.flush();
    }
}
