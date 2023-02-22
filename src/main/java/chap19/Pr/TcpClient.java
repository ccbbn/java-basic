package chap19.Pr;

import java.io.IOException;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) {


        try {
            Socket socket = new Socket("192.168.0.10",50001);
            System.out.println("연결성공");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
