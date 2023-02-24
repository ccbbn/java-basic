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

    ServerSocket serverSocket;  // 서버 소켓
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
        serverSocket = new ServerSocket(5001);
        System.out.println("[서버] 시작됨");

        Thread thread = new Thread(() -> {
           try {

               while (true) {
                   // 클라이언트 요청 대기
                   // socket에 접속한 클라이언트의 정보 담겨있음.
                   Socket socket = serverSocket.accept();
                   SocketClient sc = new SocketClient(this, socket); // 소켓에 입력된 채팅서버가 이 chatSever 클래스, (chatServer, 들어온 사람)
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
        });
        thread.start();

    }

    public void addSocketClient(SocketClient socketClient) {  // F(x)
        String key = socketClient.chatName + "@" + socketClient.clientIp;
        clients.put(key, socketClient);  // clients 맵에 키와 밸류 입력 -> (Key : 내가 임의로 정한거 - Value를 불러오기 위해/// Value: 불러올 값) -> 키를 통해서 내가 접속한 사람 확인
        System.out.println("입장 : " + key);
        System.out.println("현재 채팅자 수: " + clients.size()  + "\n");
    }  // 서버에 접속한 사람을  Map에 넣음

    public void sendToAll(SocketClient sender, String message) {  // F(X,Y) : 4X+5Y  , sendToAll( (소켓으로 연결된 사람 ->접속한사람)보내는 사람, 메시지)
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
        json.put("clientIp", sender.clientIp);  // ( Key : clientIp, Value : (소켓으로 연결된 사람 -> 접속한 사람)보내는 사람.ip )
        json.put("chatName", sender.chatName);  // ( Key : chatName, Value : (소켓으로 연결된 사람 -> 접속한 사람)보내는 사람.이름 )
        json.put("message", message); // ( Key : "message", Value : message)

        String sendData = json.toString();  // sendData = json 객체를 문자열화 한것, 한 부대를 만듦

        // 모든 클라이언트 정보 가져오기
        Collection<SocketClient> socketClients = clients.values();
        for (SocketClient sc : socketClients) {
            // 각각 연결소켓마다(접속한 사람들) 한 부대씩 보냄
            sc.send(sendData);
        }

    }// 연결된 사람에게 연결된 사람의 정보를 담은 제이슨을 보냄

    public void removeSocketClient(SocketClient socketClient) {
        // 맵에서 socketClient 제거
        String key = socketClient.chatName + "@" + socketClient.clientIp;
        clients.remove(key);
        System.out.println("나감: " + key);
        System.out.println("현재 채팅자 수: " + clients.size() + "\n");
    }
} // 키제거를 통해 특정한 key제거
