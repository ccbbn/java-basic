package chap19.chatV1;

import org.json.JSONObject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    // 채팅 서버 기능
      // 접속 기능 제공 : 클라이언트의 연결 요청을 수락
      // 접속 클라이언트들의 정보 저장 -> "연결 소켓"
      // 클라이언트 메시지 수신
      // 접속한 모든 클라이언트에게 받은 메시지를 송신

    ServerSocket serverSocket;
    ExecutorService threadPool = Executors.newFixedThreadPool(100);
    Map<String, SocketClient> clients = Collections.synchronizedMap(new HashMap<>());

    public static void main(String[] args) {
        // 메인 스레드
        try {
            ChatServer chatServer = new ChatServer();
            chatServer.start();
        } catch (Exception e) {
            e.printStackTrace();



        }
    }

    private void start() throws IOException {
        serverSocket = new ServerSocket(50001);
        System.out.println("[서버] 시작됨");

        Thread thread = new Thread(() -> {
           try {

               while (true) {
                   // 클라이언트 요청 대기
                   // socket에 접속한 클라이언트의 정보 담겨있음.
                   Socket socket = serverSocket.accept();
                   SocketClient sc = new SocketClient(this, socket);
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
        });
        thread.start();

    }

    public void addSocketClient(SocketClient socketClient) {
        String key = socketClient.chatName + "@" + socketClient.clientIp;
        clients.put(key, socketClient);
        System.out.println("입장 : " + key);
        System.out.println("현재 채팅자 수: " + clients.size()  + "\n");
    }

    public void sendToAll(SocketClient sender, String message) {
        // 데이터 송신 to 모든 클라이언트
          // 1. 보낼 데이터를 "JSON" 으로 만들기
          // 2. 문자열로 변환 (직렬화)
          // 3. 모든 클라이언트한테 보내기
          /*
            {
                "chatName" : "T없2맑은",
                "message" : "들어오셨습니다."
            }
           */
        JSONObject json = new JSONObject();
        json.put("clientIp", sender.clientIp);
        json.put("chatName", sender.chatName);
        json.put("message", message);
        String sendData = json.toString();

        // 모든 클라이언트 정보 가져오기
        Collection<SocketClient> socketClients = clients.values();
        for (SocketClient sc : socketClients) {
            // 각각 연결소켓마다 보내기 수행
            sc.send(sendData);
        }

    }

    public void removeSocketClient(SocketClient socketClient) {
        // 맵에서 socketClient 제거
        String key = socketClient.chatName + "@" + socketClient.clientIp;
        clients.remove(key);
        System.out.println("나감: " + key);
        System.out.println("현재 채팅자 수: " + clients.size() + "\n");
    }
}
