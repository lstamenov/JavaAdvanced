import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFiles {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output6.txt"));
        Path path = Paths.get("/home/lyubomir/Desktop/folder");
        File file = new File(String.valueOf(path));
        File[] files = file.listFiles();
        assert files != null;
        for (File file1 : files) {
            if (!file1.isDirectory()){
                bufferedWriter.write(String.format("%s: [%s]", file1.getName(), file1.length()));
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.flush();
    }
}
