package chap19.chatV1;


import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    Socket socket;

    // 서버로부터 데이터를 받을 때 사용하는 입력 스트림
    DataInputStream dis;
    // 서버로 데이터를 보낼 때 사용하는 출력 스트림
    DataOutputStream dos;
    String chatName;

    public static void main(String[] args) {
        try {
            ChatClient chatClient = new ChatClient();
            chatClient.connect();

            // 채팅명 입력받기
            System.out.print("채팅명 입력 > ");
            chatClient.chatName = new Scanner(System.in).next();

            // 1. json 으로 변환
            // 2. 문자열화(직렬화)
            // 3. 보내기
            JSONObject json = new JSONObject();
            json.put("command", "incoming");  // ( Key : "command" , Value : "incoming")
            json.put("data", chatClient.chatName);  // ( Key : "data", Value : "이름")
            String sendData = json.toString();

            chatClient.send(sendData);  // 서버로 제이슨을 보냄
            chatClient.receive();



        } catch (Exception e) {

        }
    }

    private void receive() {  // 서버로 부터 받는 거
        Thread thread = new Thread(() -> {
           try {
               while (true) {
                   String readData = dis.readUTF();
                   JSONObject json = new JSONObject(readData);
                   String clientIp = json.getString("clientIp"); //getString 유니코드문자를 불러옴
                   String chatName = json.getString("chatName");
                   String message = json.getString("message");
                   System.out.println("<" + chatName + "@" + clientIp + "> " + message);
               }
           } catch (Exception e) {

           }
        });
        thread.start();
    }

    private void send(String sendData) throws IOException {
        dos.writeUTF(sendData);
        dos.flush();
    }

    private void connect() throws IOException {
        socket = new Socket("192.168.200.106", 5001);  // 클라이언트 소켓
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("[클라이언트] 서버에 연결됨");
    }
}
