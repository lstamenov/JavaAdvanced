import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAPicture {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/home/lyubomir/Desktop/cv.pdf");
        FileOutputStream fileOutputStream = new FileOutputStream("cv-copy.pdf");
        fileOutputStream.write(fileInputStream.readAllBytes());
        fileOutputStream.close();
        fileInputStream.close();
    }
}
