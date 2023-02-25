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


    GameRoom gameRoom;


    ServerSocket serverSocket;
    ExecutorService threadPool = Executors.newFixedThreadPool(100);
    public static Map<String, SocketClient> guests = Collections.synchronizedMap(new HashMap<>());

    public static Map<String, SocketClient> chatMember = Collections.synchronizedMap((new HashMap<>()));

    public static Map<Integer, GameRoom> roomList = Collections.synchronizedMap((new HashMap<>()));



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

    public void addSocketClientToChatRoom(SocketClient socketClient) {
        String key = socketClient.chatMemberName + "@" + socketClient.userIP;
        chatMember.put(key, socketClient);
        System.out.println("채팅방 입장 : " + key);
        System.out.println("현재 채팅방 인원수 : " + chatMember.size());

    }


    public void sendToLobby(SocketClient socket, String message) {
        JSONObject jsonForLobby = new JSONObject();
        jsonForLobby.put("lobbyOrRoom","lobby");
        jsonForLobby.put("userIP", socket.userIP);
        jsonForLobby.put("userName", socket.userName);
        jsonForLobby.put("messageToUser", message);
        String sendData = jsonForLobby.toString();
        Collection<SocketClient> socketClients = guests.values();
        for (SocketClient sc : socketClients) {
            sc.send(sendData);
        }
    }

    public void sendToChatRoom(SocketClient socket, String message) {
        JSONObject jsonForChatRoom = new JSONObject();
        jsonForChatRoom.put("lobbyOrRoom","chatRoom");
        jsonForChatRoom.put("chatIP", socket.userIP);
        jsonForChatRoom.put("chatName", socket.chatMemberName);
        jsonForChatRoom.put("messageToChatMember", message);
        String sendData = jsonForChatRoom.toString();
        Collection<SocketClient> socketClients = chatMember.values();
        for (SocketClient sc : socketClients) {
            sc.send(sendData);
        }
    }

    public void createGameRoom(SocketClient socket, String roomName) {
        int roomCount = 0;
        String key = socket.gamerName + "@" + socket.userIP;
        GameRoom newGameRoom = new GameRoom(roomName);
        roomCount++;
        for (int i = 1; i <= roomCount; i++) {
            roomList.put(i ,newGameRoom);
        }
        newGameRoom.GameMember.put(key, socket);
        System.out.println("방이름 :" + roomName);
        System.out.println("게임방 입장 : " + key);
        System.out.println("현재 게임방 인원수 :" + newGameRoom.GameMember.size());
        System.out.println("만든 사람 :" + socket.gamerName);
        this.gameRoom = newGameRoom;
    }


    public void sendToGameRoom(SocketClient socket, String message){
        JSONObject jsonForGameRoom = new JSONObject();
        jsonForGameRoom.put("lobbyOrRoom","newGameRoom");
        jsonForGameRoom.put("gamerIP", socket.userIP);
        jsonForGameRoom.put("gamerName", socket.gamerName);
        jsonForGameRoom.put("messageToGameRoom", message);
        String sendData = jsonForGameRoom.toString();
        Collection<SocketClient> socketClients = gameRoom.GameMember.values();
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



////    public void joinGameRoom(SocketClient socket, String roomName) {
////        String key = socketClient.chatMemberName + "@" + socketClient.userIP;
////        chatMember.put(key, socketClient);
////        System.out.println("채팅방 입장 : " + key);
////        System.out.println("현재 채팅방 인원수 : " + chatMember.size());
////
//
//    }
}
