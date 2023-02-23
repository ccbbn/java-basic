package chap19.B;

import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameRoom {
    DataInputStream dis;
    DataOutputStream dos;
    String userIP;
    String gameType1;
    String roomName1;
    String gameStart;
    String gameStop;
    String chat;
    String out;
    String result;

    public Map<String, SocketClient> users = Collections.synchronizedMap(new HashMap<>());



    public static void main(String[] args) {

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
}
