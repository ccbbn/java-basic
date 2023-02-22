package chap19.Pr;

import lombok.SneakyThrows;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClientV2 {
    @SneakyThrows
    public static void main(String[] args) {
//192.168.0.10
        Socket socket = new Socket("192.168.0.10",50001);
        System.out.println("연결 성공");

        // 보조 스트림장착
        DataOutputStream dos =
                new DataOutputStream(socket.getOutputStream());
        // 데이터를 서버로 송신
        System.out.println("데이터를 입력해주세요");
        String sendDate = new Scanner(System.in).next();
        dos.writeUTF(sendDate);
        dos.flush();
        System.out.println("클라이언트 데이터를 보냄 :" + sendDate);

        // 데이터를 서버에서 수신
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        System.out.println("데이터를 받음 " + dis.readUTF());

        socket.close();



    }
}
