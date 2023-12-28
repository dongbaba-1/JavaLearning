import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class OutPutStreamDemo {

    public static void main(String[] args) throws Exception {
        FileOutputStream os = new FileOutputStream("output.txt",false);
        String str = "dasdasda我";
        byte[] buffer = str.getBytes();
        os.write(buffer,0,5);
        os.close();
    }
}
