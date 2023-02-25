package chap19.B;

import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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

            System.out.print("채팅명 입력 > ");
            user.userName = new Scanner(System.in).next();
            System.out.println("게임을 만드시겠습니까 > Y/N");
            String gameMake = new Scanner(System.in).next();
            JSONObject json = new JSONObject();

            if(gameMake.equals("Y")) {
                json.put("command", "hostIncoming");
                json.put("hostName", user.userName);
                String HostData = json.toString();
                user.send(HostData);
                user.receive();
                System.out.println("나오니?");

            } else if (gameMake.equals("N")) {
                json.put("command", "incoming");
                json.put("userName", user.userName);
                String NormalPeopleData = json.toString();
                user.send(NormalPeopleData);
                user.receive();
            }


            while (true) {
                String message = new Scanner(System.in).useDelimiter("\n").next();
                json.put("command", "messageToAll");
                json.put("message", message);
                String sendData = json.toString();
                user.send(sendData);

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
                    String userIP = json.getString("userIP");

                    String userName = json.getString("userName");

                    String message = json.getString("message");
                    System.out.println("<" + userName + "@" + userIP + ">" + message);
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
        socket = new Socket("localhost", 50001);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("[서버]에 연결됨");
    }

}
