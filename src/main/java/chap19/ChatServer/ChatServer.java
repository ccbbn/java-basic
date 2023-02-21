package chap19.ChatServer;

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
    // 기능
    // 접속 기능 제공 : 클라이언트의 연결 요청을 수락
    // 클라이언트들의 정보를 저장/관리 ->  연결 소켓(IP, Port)
    // 클라이언트 메시지 수신
    // 모든 클라이언트에게 받은 메시지를 송신

    ServerSocket serverSocket;
    ExecutorService threadPool = Executors.newFixedThreadPool(100);

    Map<String, Socket> clients = Collections.synchronizedMap(new HashMap<>());

    public static void main(String[] args) {


        try {
            ChatServer chatServer = new ChatServer();
            chatServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void start() throws IOException {

        serverSocket = new ServerSocket(50001);
        System.out.println("서버 시작");

        Thread thread = new Thread( () ->{

            try {


                while(true) {
                    // 클라이언트 요청대기
                    // socket에 접속한 클라이언트의 정보를 저장해야 한다
                    Socket socket = serverSocket.accept();
                    SocketClient sc = new SocketClient(this, socket);


                }
            } catch (IOException e) {
                e.printStackTrace();
            }



        });









    }




    public void addSocketClient(SocketClient socketClient){
        String key = socketClient.chatName + "@" + socketClient.clientIp;
        clients.put(key, socketClient);

    }

    public void sendToAll(SocketClient sender) {
        // 데이터 송신을 모든 클라이언트에게
            // 1.보낼 데이터를 JSON으로 만들기
            // 2.문자여롤 변환
            // 3. 모든 클라이언트한테 보내기
            /*
            {
                "chatName" : "ㅇㅅㅇ"
                "message" : "들어왔니"
             */

        JSONObject json = new JSONObject();
        json.put("아이피", sender.clientIp);
        json.put("챗이름",sender.chatName);
        json.put("메시지",message);
        String sendData = json.toString();
        // 모든 클라이언트 정보 가져오기
        Collection<SocketClient> socketClients = clients.values();
        for(SocketClient sc : socketClients) {
            sc.send(sendData);
        }
    }

    public void removeSocketClient() {
        //맵에서 socketClient제거
        String key = socketClient.chatName + "@" + socketClient.clientIp;
        clients.remove(key);
        System.out.println("나감"  +key);
        System.out.println("현재" + clients.size());
    }
}
