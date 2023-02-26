package chap19.B;

import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static chap19.B.Server.roomList;

public class User {

    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    String userName;
    String message;
    String hostName;

    String user;
    String Host;


    public static void main(String[] args) {
        try {
            User user = new User();
            user.connect();
            System.out.print("닉네임입력 > ");
            user.userName = new Scanner(System.in).next();
            System.out.println("1. 로비   | 2. 채팅방 | 3. 방 만들기 | 4. 방 입장하기" );
            String choice = new Scanner(System.in).next();
            JSONObject json = new JSONObject();

            switch(choice) {
                case "1" :
                    System.out.println("로비에 입장합니다.");
                    json.put("command", "incoming");
                    json.put("userName", user.userName);
                    String sendData = json.toString();
                    user.send(sendData);
                    user.receive();

                    while (true) {
                        String message = new Scanner(System.in).useDelimiter("\n").next();
                        json.put("command", "messageToAll");
                        json.put("message", message);
                        sendData = json.toString();
                        user.send(sendData);
                    }

                case "2" :
                    System.out.println("채팅방에 입장합니다.");
                    json.put("command", "chatRoomIncoming");
                    json.put("userName", user.userName);
                    String sendDataToChatRoom = json.toString();
                    user.send(sendDataToChatRoom);
                    user.receive();

                    while (true) {
                        String message = new Scanner(System.in).useDelimiter("\n").next();
                        json.put("command", "messageToChatMember");
                        json.put("message", message);
                        sendData = json.toString();
                        user.send(sendData);
                    }

                case "3" :
                    System.out.println("게임방을 만듭니다.");
                    System.out.print("방제 : ");
                    String roomName = new Scanner(System.in).useDelimiter("\n").next();
                    json.put("command", "createGameRoom");
                    json.put("userName",user.userName);
                    json.put("roomName", roomName);
                    String sendDataToGameRoom = json.toString();
                    user.send(sendDataToGameRoom);
                    user.receive();

                    while (true) {
                        String message = new Scanner(System.in).useDelimiter("\n").next();
                        json.put("command","messageToGameRoom");
                        json.put("message", message);
                        sendData = json.toString();
                        user.send(sendData);
                    }

                case "4" :
                    System.out.println("현재 방 목록을 보여줍니다.");
                    if (roomList.size() != 0) {
                        for (int i = 1 ; i <= roomList.size(); i++ ) {
                            System.out.println("[" + i + "번방]"+ roomList.get(i).getRoomName());
                        }
                    } else
                        System.out.println("현재 개설된 방은 없음");

                    System.out.print("입장하고 싶은 방제목을 입력하세요 > ");
                    String inputtedRoomName = new Scanner(System.in).useDelimiter("\n").next();
                    json.put("command", "joinGameRoom");
                    json.put("playerName", user.userName);
                    json.put("inputtedRoomName", inputtedRoomName);
                    String sendDataToJoinedGameRoom = json.toString();
                    user.send(sendDataToJoinedGameRoom);
                    user.receive();


            }


        } catch (Exception e) {
            e.getMessage();

        }
    }

    private void receive() {    // 받는 건 쓰레드로
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    String readData = dis.readUTF();
                    JSONObject json = new JSONObject(readData);

                if( json.getString("roomType").equals("lobby") ) {

                    String userIP = json.getString("userIP");
                    String userName = json.getString("userName");
                    String message = json.getString("messageToUser");
                    System.out.println("<" + userName + "@" + userIP + ">" + message);

                } else if(json.getString("roomType").equals("chatRoom")) {

                    String chatIP = json.getString("chatIP");
                    String chatName = json.getString("chatName");
                    String message = json.getString("messageToChatMember");
                    System.out.println("<" + chatName + "@" + chatIP + ">" + message);

                } else if(json.getString("roomType").equals("newGameRoom")){

                    String hostIP = json.getString("hostIP");
                    String hostName = json.getString("hostName");
                    String message = json.getString("messageToGameRoom");
                    System.out.println("<" + hostName + "@" + hostIP + ">" + message);

                } else if(json.getString("roomType").equals("joinedGameRoom")) {

                    String playerIP = json.getString("playerIP");
                    String playerName = json.getString("playerName");
                    String message = json.getString("messageToJoinedGameRoom");
                    System.out.println("<" + playerName + "@" + playerIP + ">" + message);




                }








                }
            } catch (Exception e) {

            }
        });
        thread.start();
    }


    private void joinGame(){
        try {
            while (true) {
                String readData = dis.readUTF();
                JSONObject json = new JSONObject(readData);
                String clientIp = json.getString("clientIp");
                String chatName = json.getString("chatName");
                String message = json.getString("message");
                String player = json.getString("player");
                System.out.println("<" + chatName + "@" + clientIp + "> " + message);
            }
        } catch (Exception e) {
            e.getMessage();
        }

    }


    private void send(String sendData) throws IOException {
        dos.writeUTF(sendData);
        dos.flush();
    }
    private void connect()throws IOException {
        socket = new Socket("192.168.200.106", 50001);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("[서버]에 연결됨");
    }

}
