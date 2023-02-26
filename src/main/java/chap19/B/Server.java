package chap19.B;

import org.json.JSONObject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Server {



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
        jsonForLobby.put("roomType","lobby");
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
        jsonForChatRoom.put("roomType","chatRoom");
        jsonForChatRoom.put("chatIP", socket.userIP);
        jsonForChatRoom.put("chatName", socket.chatMemberName);
        jsonForChatRoom.put("messageToChatMember", message);
        String sendData = jsonForChatRoom.toString();
        Collection<SocketClient> socketClients = chatMember.values();
        for (SocketClient sc : socketClients) {
            sc.send(sendData);
        }
    }
    int roomCount = 1;
    public void createGameRoom(SocketClient socket, String roomName) {

        String key = socket.hostName + "@" + socket.userIP;
        GameRoom newGameRoom = new GameRoom(roomName);
        newGameRoom.GameMember.put(key, socket);

        roomList.put(roomCount++ ,newGameRoom);
        System.out.println("========개설된 게임방 =========");
        for (int i = 1; i < roomCount; i++) {
            System.out.println(roomList.get(i).getRoomName());
        }
        System.out.println("=============================");

        System.out.println("생성된 게임방 이름 :" + roomName);
        System.out.println(roomName + " 게임방의 방장 : " + "☆★" + socket.hostName  + "☆★" );
        System.out.println("현재 " + roomName +" 게임방의 인원수 :" + newGameRoom.GameMember.size());

//        this.gameRoom = newGameRoom;
    }


    public void sendToGameRoom(SocketClient socket, String message){
        JSONObject jsonForGameRoom = new JSONObject();
        jsonForGameRoom.put("roomType","newGameRoom");
        jsonForGameRoom.put("hostIP", socket.userIP);
        jsonForGameRoom.put("hostName", socket.hostName);
        jsonForGameRoom.put("messageToGameRoom", message);
        String sendData = jsonForGameRoom.toString();
        Collection<SocketClient> socketClients = roomList.get(roomCount-1).GameMember.values();
        for (SocketClient sc : socketClients) {
            sc.send(sendData);
        }
    }

    public void joinGameRoom(SocketClient socket, String inputtedRoomName) {
        String key = socket.chatMemberName + "@" + socket.userIP;

        for (int i = 1; i < roomCount; i++) {
            if (roomList.get(i).getRoomName().equals(inputtedRoomName)) {
                roomList.get(i).GameMember.put(key, socket);
            }
            System.out.println( roomList.get(i).getRoomName() + " 입장 : " + key);
            System.out.println("현재 인원수 : " + roomList.get(i).GameMember.size());

        }
    }

    public void sendToJoinedGameRoom(SocketClient socket, String message, String inputtedRoomName) {
        JSONObject jsonForJoinedGameRoom = new JSONObject();
        jsonForJoinedGameRoom.put("roomType","joinedGameRoom");
        jsonForJoinedGameRoom.put("playerIP", socket.userIP);
        jsonForJoinedGameRoom.put("playerName", socket.playerName);
        jsonForJoinedGameRoom.put("messageToJoinedGameRoom", message);
        String sendData = jsonForJoinedGameRoom.toString();

        for (int i = 1; i < roomCount; i++) {
            if (roomList.get(i).getRoomName().equals(inputtedRoomName)) {
                Collection<SocketClient> socketClients = roomList.get(i).GameMember.values();
                for (SocketClient sc : socketClients) {
                    sc.send(sendData);
                }
            }
        }
    }


//    public void addSocketRoomInfo(SocketClient socketClient) {
//        String key = socketClient.userName + "@" + socketClient.userIP;
//        guests.put(key, socketClient);
//    }


    public void roomInfo() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("roomList", "roomList1");
        jsonObject.put("roomInfo",roomList.get(1).getRoomName());

        String sendData = jsonObject.toString();
        Collection<SocketClient> socketClients = guests.values();
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



}
