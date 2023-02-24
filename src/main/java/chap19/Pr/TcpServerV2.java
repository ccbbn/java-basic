package chap19.Pr;

import lombok.SneakyThrows;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerV2 {



    private static ServerSocket serverSocket = null;
    public static void main(String[] args) {

        startServer();
    }

    private static void startServer() {
        Thread thread = new Thread(){

            @SneakyThrows
            @Override
            public void run() {
                serverSocket = new ServerSocket(5001);  // 서버를 만듦
                System.out.println("서버 시작됨");

                //쓰레드를 더 만들면 동시에 다른 사람을 기다리 않아아도 됨. 쓰레드 1개면 할당된 사람의 작없이 다 끝나야 다른 사람이 연결됨

                while (true) {
                    System.out.println("서버 연결 요청을 기다림");
                    Socket socket = serverSocket.accept(); //  클라이언트가 서버로 접속하게 함// 클라이언트가 소켓을 만들면

                    InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                    System.out.println("서버: " + isa.getHostName() + "/" +isa.getAddress() + "의 연결요청을 수락함");


                    DataInputStream dis = new DataInputStream(socket.getInputStream());//클라이언트와 연결됨 스트림
                    String message = dis.readUTF(); // readUTF <-  스캔 ,dis가 입력한 것을 메시지에 넣음
                    System.out.println("서버 데이터 수신 " +  message);


                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());// 받은 데이터 다시 전송
                    dos.writeUTF(message);
                    dos.flush();
                    System.out.println("서버 데티어 송신 " + message);

                    socket.close();
                    System.out.println("서버 " +isa.getHostName() +"의 연결을 끊음");
                }
            }
        };
        thread.start();

    }
}
