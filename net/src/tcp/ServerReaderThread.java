package tcp;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import static tcp.Server.sockets;
public class ServerReaderThread extends Thread{
    private Socket socket;
    public ServerReaderThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            System.out.println("有人上线了：" + socket.getRemoteSocketAddress());
            InputStream inputStream = socket.getInputStream();
            DataInputStream dis = new DataInputStream(inputStream);
            System.out.println("线上人数：" + sockets.size());

            while (true){
                try {
                    //卡在这里，等待消息传过来
                    String msg = dis.readUTF();
                    System.out.println(msg);
                    //向socket列表里的所有socket写这条消息
                    for (Socket socket1 : sockets) {
                        //System.out.println("十大");
                        OutputStream outputStream = socket1.getOutputStream();
                        DataOutputStream dos = new DataOutputStream(outputStream);
                        dos.writeUTF("来自客户端" + socket1.getLocalSocketAddress() +msg);
                        //dos.close();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    socket.close();
                    dis.close();
                    break;
                }
            }
            System.out.println("有人下线了：" + socket.getRemoteSocketAddress());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
