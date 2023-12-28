import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class InputDemo {
    public static void main(String[] args) throws Exception {
        /*FileInputStream fileInputStream = new FileInputStream("input.txt");
        File readFile = new File("input.txt");
//        for (int i = 0;i<readFile.length();++i){
//            System.out.print(fileInputStream.read());
//        }
        int b;
        while((b = fileInputStream.read()) != -1){
            System.out.print(b);
        }

        //关闭文件流
        fileInputStream.close();*/

        /*FileInputStream fileInputStream = new FileInputStream("input.txt");
        byte[] buffer = new byte[3];//byte[] 的长度决定了一次读取的字节数,1024个字节
        int bufferRead = fileInputStream.read(buffer);
        while (bufferRead!= -1){
            String str = new String(buffer,0,bufferRead);
            System.out.println(str);
            bufferRead= fileInputStream.read(buffer);
        }

        fileInputStream.close();*/

        //一次性读完全部字节
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        //byte[] buffer = new byte[(int)new File("input.txt").length()];
        //int bufferRead = fileInputStream.read(buffer);
        byte[] buffer = fileInputStream.readAllBytes();
        String str = new String(buffer);
        System.out.println(str);




    }

}
