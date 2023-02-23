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


    public static void main(String[] args) {
        try {
            User user = new User();
            user.connect();

            System.out.print("채팅명 입력 > ");
            user.userName = new Scanner(System.in).next();
            System.out.println("게임을 만드시겠습니까 > Y/N");
            String gameMake = new Scanner(System.in).next();

            JSONObject json = new JSONObject();
            json.put("command", "incoming");
            json.put("userName", user.userName);
            String sendData = json.toString();

            user.send(sendData);
            user.receive();

            // createGameRoom1  (if creat room -> host다)
            if(gameMake.equals("Y")) {
                json = new JSONObject();
                json.put("command", "createGameRoom1");
                json.put("hostName", user.userName);
                //json.put();
                //json.put();
                sendData = json.toString();
                user.send(sendData);
            }
//            //out
//            if() {
//
//            }

            while (true) {
                String message = new Scanner(System.in).useDelimiter("\n").next();

                json = new JSONObject();
                json.put("command", "message");
                json.put("data", message);
                sendData = json.toString();
                user.send(sendData);
                continue;
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
        socket = new Socket("localhost", 50001);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("[서버]에 연결됨");
    }

}
