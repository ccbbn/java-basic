package chap19.B;

import chap11.ex03.Sys;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.net.Socket;
import java.util.Scanner;

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
            System.out.println("1. 로비   | 2. 방개설");
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
                    System.out.println("게임방에 입장합니다.");

                    json.put("command", "gameRoomIncoming");
                    json.put("userName", user.userName);
                    String sendDataToGameRoom = json.toString();
                    user.send(sendDataToGameRoom);
                    user.receive();

                    while (true) {
                        String message = new Scanner(System.in).useDelimiter("\n").next();
                        json.put("command", "messageToPlayer");
                        json.put("message", message);
                        sendData = json.toString();
                        user.send(sendData);
                    }



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




                if( json.getString("lobbyOrGameRoom").equals("lobby") ) {


                    String userIP = json.getString("userIP");
                    String userName = json.getString("userName");
                    String message = json.getString("messageUser");
                    System.out.println("<" + userName + "@" + userIP + ">" + message);

                } else if(json.getString("lobbyOrGameRoom").equals("GameRoom")) {


                    String playerIP = json.getString("playerIP");
                    String playerName = json.getString("playerName");
                    String messageToPlayer = json.getString("messagePlay");
                    System.out.println("<" + playerName + "@" + playerIP + ">" + messageToPlayer);
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
    public void createRoom1(String hostName, String gameType1, String roomName1, SocketClient socketClient) {

        GameRoom gameRoom = new GameRoom();
        String key = hostName;
        gameRoom.players.put(key, socketClient);
        System.out.println("방장 " + hostName + "이/가" +  roomName1+ " 으로 "+ gameType1 + "을 생성했습니다." );
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
