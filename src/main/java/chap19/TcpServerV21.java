package chap19;

import lombok.SneakyThrows;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpServerV21 {
    private static ServerSocket serverSocket = null;

 //-------------매우중요
    //쓰레드 풀 구현
    private static ExecutorService executorService
            = Executors.newFixedThreadPool(2);
    //-------------매우중요
    public static void main(String[] args) {

        startServer();
    }

    private static void startServer() {
        Thread thread = new Thread(){

            @SneakyThrows
            @Override
            public void run() {
                serverSocket = new ServerSocket(50001);
                System.out.println("서버 시작됨");

                //일을 분리하는 쓰레드 추가

                while (true) {
                    // 연결받는 쓰레드
                    System.out.println("서버 연결 요청을 기다림");
                    Socket socket = serverSocket.accept();

                    executorService.execute( () -> {
                    try {

                            InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                            System.out.println("서버: " + isa.getHostName() + "/" +isa.getAddress() + "의 연결요청을 수락함");

                            DataInputStream dis = new DataInputStream(socket.getInputStream());//클라이언트와 연결됨 스트림
                            String message = dis.readUTF();
                            System.out.println("서버 데이터 수신 " +  message);

                            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());// 받은 데이터 다시 전송
                            dos.writeUTF(message);
                            dos.flush();
                            System.out.println("서버 데티어 송신 " + message);

                            socket.close();
                            System.out.println("서버 " +isa.getHostName() +"의 연결을 끊음");

                        } catch (Exception e){
                        e.printStackTrace();
                    }
                    });
                }
            }
        };
        thread.start();
    }
}
