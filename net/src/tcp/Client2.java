package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args){

        System.out.println(Server.sockets.size());

//        //1、创建Socket对象，同时请求与服务器程序的连接
//        Socket socket = new Socket("127.0.0.1",8888);//请求连接的服务器地址与端口
//        System.out.println("已经与服务器连接");
//        //2、从socket通信管道中得到一个字节输出流，用来发数据给服务端城西
//        OutputStream os = socket.getOutputStream();
//        InputStream is = socket.getInputStream();
//        //3、把低级的字符输出流包装成数据输出流
//        DataOutputStream dos = new DataOutputStream(os);
//        DataInputStream dis = new DataInputStream(is);
//
//        Scanner sc = new Scanner(System.in);
//        dos.writeUTF("你好，这是使用tcp协议的客户端发送的消息");
//        while(true){
////            System.out.println("进入while");
//            String str = sc.next();
//            if(str.equals("exit"))
//                break;
//            //4、开始写数据出去
//            dos.writeUTF(str);
//
//        }
//        dos.close();
//        socket.close(); //释放连接资源
    }
}
