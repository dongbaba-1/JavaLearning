import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileCopy {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("input.txt");
        FileOutputStream os = new FileOutputStream("output.txt",false);
        byte[] temp = new byte[(int)new File("input.txt").length()];
        inputStream.read(temp);
        os.write(temp);

        inputStream.close();
        os.close();
    }
}
