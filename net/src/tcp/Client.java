package tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;



import static tcp.Server.sockets;


public class Client{

    public static void main(String[] args) throws Exception {

        System.out.println(sockets.size());

        //1、创建Socket对象，同时请求与服务器程序的连接
        Socket socket = new Socket("127.0.0.1",8888);//请求连接的服务器地址与端口

        //2、从socket通信管道中得到一个字节输出流，用来发数据给服务端城西
        OutputStream os = socket.getOutputStream();
        //InputStream is = socket.getInputStream();
        //3、把低级的字符流包装成数据流
        DataOutputStream dos = new DataOutputStream(os);
        //DataInputStream dis = new DataInputStream(is);

        Scanner sc = new Scanner(System.in);
        //dos.writeUTF("你好，这是使用tcp协议的客户端"+ socket.getRemoteSocketAddress() +"发送的消息");
        while(true){
            String str = sc.next();
            if(str.equals("exit"))
                break;
            //4、开始写数据出去
            dos.writeUTF("来自客户端"+ socket.getLocalSocketAddress() + "的消息：" + str);
            //读来自其他socket的消息
            for (Socket socket1 : sockets) {
                System.out.println("进入循环");
                InputStream is = socket1.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                System.out.println(dis.readUTF());
            }
            //System.out.println(dis.readUTF());
        }
        dos.close();
        socket.close(); //释放连接资源
    }
}
