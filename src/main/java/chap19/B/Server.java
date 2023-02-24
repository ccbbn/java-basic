package chap19.B;

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

public class Server {


    ServerSocket serverSocket;
    ExecutorService threadPool = Executors.newFixedThreadPool(100);
    public static Map<String, SocketClient> clients = Collections.synchronizedMap(new HashMap<>());
    Map<String, GameRoom> gameRooms = Collections.synchronizedMap(new HashMap<>());

    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() throws IOException, IOException {
        serverSocket = new ServerSocket(50001);
        System.out.println("[서버] 시작됨");

        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    // 클라이언트 요청 대기
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
        String key = socketClient.userName + "@" + socketClient.userIP;
        clients.put(key, socketClient);
        System.out.println("입장 : " + key);
        System.out.println("현재 참여자 수: " + clients.size());
        System.out.println("게임 생성을 원하시면 gamestart!!를 치세요!");
    }

    public void sendToAll(SocketClient socket, String message) {
        JSONObject json = new JSONObject();
        json.put("userIP", socket.userIP);
        json.put("userName", socket.userName);
        json.put("messageToAll", message);
        String sendData = json.toString();

        // 모든 클라이언트 정보 가져와서 sendData
        Collection<SocketClient> socketClients = clients.values();
        for (SocketClient sc : socketClients) {
            sc.send(sendData);
        }
    }


    public void removeSocketClient(SocketClient socketClient) {
        String key = socketClient.userName + "@" + socketClient.userIP;
        clients.remove(key);
        System.out.println("나감: " + key);
        System.out.println("현재 채팅자 수: " + clients.size() + "\n");
    }


    public void createRoom1(String hostName, String gameType1, String roomName1, SocketClient socketClient) {

        GameRoom gameRoom = new GameRoom();
        String key = hostName;
        gameRoom.users.put(key, socketClient);
        System.out.println("방장 " + hostName + "이/가" +  roomName1+ " 으로 "+ gameType1 + "을 생성했습니다." );
    }

//    public void joinGameRoom(String userName, String roomName, ) {
//        // 들어갈 때
//        GameRoom gameRoom = gameRooms.get("roomName");
//
//        // userName을 가지고 SocketClient를 찾아서 게임룸 안에 users 맵에 넣어준다.
//        //gameRoom.users.put(userName, )
//
//    }
}
