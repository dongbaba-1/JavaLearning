package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static ArrayList<Socket> sockets = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.out.println("服务器端启动");
        System.out.println("线上人数：" + sockets.size());
        //服务器监听端口8888,换句话说该服务器端口号是8888
        ServerSocket serverSocket = new ServerSocket(8888);
        while(true) {
//            if(!serverSocket.isBound()){
//                System.out.println("无客户端连接，关闭服务器端");
//                serverSocket.close();
//                break;
//            }
            //阻塞在这里，等待客户端的连接请求
            Socket socket = serverSocket.accept();
            sockets.add(socket);
            //主线程收到连接请求，生成一个socket并交给一个子线程处理
            new ServerReaderThread(socket).start();
//        Socket socket2 = serverSocket.accept();
//        System.out.println("111");
//            InputStream inputStream = socket.getInputStream();
////        InputStream inputStream2 = socket2.getInputStream();
//            OutputStream outputStream = socket.getOutputStream();
//            DataOutputStream dos = new DataOutputStream(outputStream);
//            DataInputStream dis = new DataInputStream(inputStream);
////        DataInputStream dis2 = new DataInputStream(inputStream2);
//            while(true){
//                try {
//                    System.out.println(dis.readUTF());
////                System.out.println(dis2.readUTF());
//                }catch (Exception e){
//                    System.out.println("客户端已离线");
//                    dos.close();
//                    socket.close();
//                    break;
//                }
//            }
//        }
//        System.out.println(dis.readUTF());
//        dos.writeUTF("这里是服务器，收到了您发送的消息");
        }
    }
}
