package udp;

import java.net.*;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        //1、创建客户端对象
        DatagramSocket client = new DatagramSocket(); // 随机分配端口号

        //2、创建数据包
        byte[] data ;
        Scanner sc = new Scanner(System.in);
        InetAddress address = InetAddress.getLocalHost();
        while(true){
            String message = sc.next();
            if(Objects.equals(message, "exit"))
                break;;
            data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data,data.length,address,1055);
            //3、发送数据包
            client.send(packet);
            System.out.println("客户端发送数据");
        }
//        String hello = "helloworld";
//        data = hello.getBytes();
        client.close(); //关闭客户端


    }
}
