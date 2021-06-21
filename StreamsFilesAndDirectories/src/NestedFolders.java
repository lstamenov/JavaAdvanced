import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NestedFolders {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output7.txt"));
        File file = new File("/home/lyubomir/Desktop/folder");
        File[] files = file.listFiles();
        assert files != null;
        for (File f : files) {
            bufferedWriter.write(f.getName());
            if (f.isDirectory()) {
                File[] files1 = f.listFiles();
                assert files1 != null;
                for (File file1 : files1) {
                    if (file1.isDirectory()) {
                        for (File f1 : files1) {
                            System.out.println(f1.getName());
                        }
                    }
                }
            }
        }
        bufferedWriter.flush();
    }
}
