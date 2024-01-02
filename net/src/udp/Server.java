package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) throws Exception {
        //1、创建服务端对象
        DatagramSocket server = new DatagramSocket(1055);

        //2、创建接受数据的数据包
        byte[] data = new byte[1024 * 64]; //64KB一定能把数据接受完
        DatagramPacket receiver = new DatagramPacket(data,data.length);
        System.out.println("服务端已运行，等待发送数据");
        //3、接收数据
        while (true){

            server.receive(receiver);
            System.out.println("服务端收到来自端口" + receiver.getPort() +"的消息：");
            int len = receiver.getLength();
            String str = new String(data,0,len);
            System.out.println(str);

//            System.out.println(receiver.getAddress());//get客户端地址
//            System.out.println();//get客户端端口
        }

        //server.close();
    }
}
