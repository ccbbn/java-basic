package chap19.chatV2;


import chap11.ex03.Sys;
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
            json.put("command", "incoming");
            json.put("data", chatClient.chatName);
            String sendData = json.toString();

            chatClient.send(sendData);
            chatClient.receive();

            while (true) {

                String message = new Scanner(System.in).useDelimiter("\n").next();

                // /s 재연 비밀이야~~~ 어쩌구 저저꾸
                // { "/s", "재연", "비밀이야~~~" }
                if (message.split(" ")[0].equals("/s")) {
                    json = new JSONObject();
                    json.put("command", "secret");
                    json.put("data", message.split(" ")[1]);

                    String[] strArr = message.split(" ");
                    String secretData = "";
                    for (int i = 2; i < strArr.length; i++) {
                        secretData += strArr[i] + " ";
                    }
                    json.put("secret_data", secretData);
                    sendData = json.toString();
                    chatClient.send(sendData);
                    continue;
                }
                json = new JSONObject();
                json.put("command", "message");
                json.put("data", message);
                sendData = json.toString();
                chatClient.send(sendData);
            }



        } catch (Exception e) {

        }
    }

    private void receive() {
        Thread thread = new Thread(() -> {
           try {
               while (true) {
                   String readData = dis.readUTF();
                   JSONObject json = new JSONObject(readData);
                   String clientIp = json.getString("clientIp");
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
        socket = new Socket("localhost", 50001);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("[클라이언트] 서버에 연결됨");
    }
}
