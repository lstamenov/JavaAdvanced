
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetFolderSize {
    public static void main(String[] args) {
        Path path = Paths.get("/home/lyubomir/Desktop/fold/Exercises Resources");
        File file = new File(String.valueOf(path));
        System.out.println(file.length());
    }
}
