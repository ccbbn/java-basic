package chap19.B;

import lombok.SneakyThrows;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameRoom {

    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    String playerName;



    public Map<String, SocketClient> players = Collections.synchronizedMap(new HashMap<>());



    @SneakyThrows
    public static void main(String[] args) {

        GameRoom gameRoom = new GameRoom();
        gameRoom.connectionFromGameRoom();

        System.out.println(":");



    }

    private void receive() {    // 받는 건 쓰레드로
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    String readData = dis.readUTF();
                    JSONObject json = new JSONObject(readData);
                    String userName = json.getString("userName");
                    String hostName = json.getString("hostName");
                    String message = json.getString("message");
                    System.out.println("<" + userName + "> " + message);



                }
            } catch (Exception e) {
                e.getMessage();
            }
        });
        thread.start();
    }



    private void connectionFromGameRoom()throws IOException {
        socket = new Socket("localhost", 50001);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("[서버]에 연결됨");
    }
}
