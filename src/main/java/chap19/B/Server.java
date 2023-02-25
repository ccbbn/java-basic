package chap19.B;

import org.json.JSONObject;

import java.io.IOException;
import java.io.PushbackInputStream;
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
    public static Map<String, SocketClient> guests = Collections.synchronizedMap(new HashMap<>());
    public static Map<String, SocketClient> players = Collections.synchronizedMap((new HashMap<>()));

    public static Map<String, SocketClient> players2 = Collections.synchronizedMap((new HashMap<>()));
    
    
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
        guests.put(key, socketClient);
        System.out.println("입장 : " + key);
        System.out.println("현재 대기실 인원수 : " + guests.size());
    }

    public void addSocketClientForHost(SocketClient socketClient) {
        String key = socketClient.hostName + "@" + socketClient.userIP;
        guests.put(key, socketClient);
        System.out.println("입장 : " + key);
        System.out.println("현재 대기실 인원수 : " + guests.size());
    }



    public void addSocketClientToGameRoom(SocketClient socketClient) {
        String key = socketClient.playerName + "@" + socketClient.userIP;
       // guests.remove(key);
        players.put(key, socketClient);
        System.out.println("게임방 입장 : " + key);
        System.out.println("현재 게임방 인원수 : " + players.size());

        
    }
    
    

    public void sendToAll(SocketClient socket, String message) {
        JSONObject jsonForLobby = new JSONObject();
        jsonForLobby.put("lobbyOrGameRoom","lobby");
        jsonForLobby.put("userIP", socket.userIP);

        jsonForLobby.put("userName", socket.userName);
        jsonForLobby.put("messageUser", message);
        String sendData = jsonForLobby.toString();

        // 모든 클라이언트 정보 가져와서 sendData
        Collection<SocketClient> socketClients = guests.values();
        for (SocketClient sc : socketClients) {
            sc.send(sendData);
        }
    }

    public void sendToGameRoom(SocketClient socket, String message) {
        JSONObject jsonForGameRoom = new JSONObject();
        jsonForGameRoom.put("lobbyOrGameRoom","GameRoom");
        jsonForGameRoom.put("playerIP", socket.userIP);

        jsonForGameRoom.put("playerName", socket.playerName);
        jsonForGameRoom.put("messagePlay", message);
        String sendData = jsonForGameRoom.toString();

        // 모든 클라이언트 정보 가져와서 sendData
        Collection<SocketClient> socketClients = players.values();
        for (SocketClient sc : socketClients) {
            sc.send(sendData);
        }
    }






    public void sendToAllFromHost(SocketClient socket, String message) {
        JSONObject jsonForLobby = new JSONObject();
        jsonForLobby.put("userIP", socket.userIP);
        jsonForLobby.put("userName", socket.hostName);
        jsonForLobby.put("message", message);
        String sendData = jsonForLobby.toString();

        Collection<SocketClient> socketClients = guests.values();
        for (SocketClient sc : socketClients) {
            sc.send(sendData);
        }
    }









    private void sendToPlayers(SocketClient socket, String answer) {
        JSONObject jsonForGameRoom = new JSONObject();
        jsonForGameRoom.put("userIP", socket.userIP);
        jsonForGameRoom.put("userName", socket.userName);
        jsonForGameRoom.put("answerTheGame", answer);
        String sendData = jsonForGameRoom.toString();

        Collection<SocketClient> socketClients = players.values();
        for (SocketClient sc : socketClients) {
            sc.send(sendData);
        }
    }

    public void removeSocketClient(SocketClient socketClient) {
        String key = socketClient.userName + "@" + socketClient.userIP;
        guests.remove(key);
        System.out.println("나감: " + key);
        System.out.println("현재 채팅자 수: " + guests.size() + "\n");
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
