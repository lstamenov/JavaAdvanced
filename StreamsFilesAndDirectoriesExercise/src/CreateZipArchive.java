import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    public static void main(String[] args) throws IOException {
        String fFilePath = "/home/lyubomir/Desktop/txt1.txt";
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("/home/lyubomir/Desktop/arch.zip"));
        FileInputStream fos = new FileInputStream(fFilePath);
        int byteCont;
        zos.putNextEntry(new ZipEntry("txt1.txt"));
        while ((byteCont = fos.read()) >= 0){
            zos.write(byteCont);
        }
        zos.closeEntry();
        zos.close();
        fos.close();
    }
}
