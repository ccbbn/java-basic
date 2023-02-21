package chap19;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
//      프로토콜: 이메일 같은 형식 적으로 정해진 것 , 서로 소통하기 위해 정한 약속
//      tcp: 연결형 프로토콜 - 서로 간의 연결을 확인하고 연결이 수립되었을 경우에만 데이터를 주고 받음
//      3-way handshake - 살아있니?, ㅇㅇ, 그럼 데이터 보낼게
//      자바의 tcp : ServerSocket, Socket 클래스
//      ServerSocket: 서버,      Socket: 소켓

//      1) 서버 소켓 생성 -> ip주소와 port번호를 바인딩
//      2) 클라이언트 연결 요청 대기 - 요청 전까지 블로킹 , 핸드폰 개통과 비슷
//      3) 연결 요청
//      4) 데이터통신을 위한 소켓 생성
//      5)

    private static ServerSocket serverSocket = null;
    public static void main(String[] args) {

        try {
            serverSocket = new ServerSocket(50001); // 연결을 대기하하고 수락하는 소켓
            System.out.println("서버가 시작됨");


            while (true) {
                System.out.println("연결요청 기다림");
                Socket socket = serverSocket.accept();// 요청한 클라이언트와 데이터 통신을위한 소켓 ,블로킹

                socket.getInputStream(); // 클라이언트가 보낸 데이터를 읽을 수 있는 입출력 스트림
                socket.getOutputStream();


                InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress(); // ㅅ버와 연결된 클라이언트 주소 정보
                System.out.println("서버: " + isa.getHostName() + "/" +isa.getAddress() + "의 연결요청을 수락함");

                socket.close();// 연결끊기
                System.out.println("서버: " + isa.getHostName() + "/" +isa.getAddress() + "의 연결요청을 끊음");


            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}


