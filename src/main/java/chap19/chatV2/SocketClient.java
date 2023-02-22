package chap19.chatV2;

import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

// 기존 기능에 추가 기능을 더하기 위해서 만든 클래스
public class SocketClient {
    ChatServer chatServer;
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    String clientIp;

    String chatName;

    public SocketClient(ChatServer chatServer, Socket socket) {


        try {
            // 초기화
            this.chatServer = chatServer;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
            this.clientIp = isa.getHostName();

            // 스레드 풀에서 스레드 하나 가져와서 "데이터 송수신 작업" 처리
            receive();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 접속 클라이언트들의 정보 저장
    // 클라이언트의 데이터를 수신받고
    // 접속한 모든 클라이언트에게 송신

    /*
        - command
            - incoming : 채팅명
            - message : 메시지
            - secret : 상대방 채팅명
        - data
        - secret_message
     */
    private void receive() {
        chatServer.threadPool.execute(() -> {
            try {
                while (true) {
                    // 데이터 수신 (JSON)
                    String receiveData = dis.readUTF();

                    // 데이터를 주고 받는 데이터 타입 : "JSON"
                    JSONObject json = new JSONObject(receiveData);
                    String command = json.getString("command");

                    switch (command) {
                        // 처음 접속할 때 :
                        case "incoming":
                            // 채팅명이 담겨져 있음 ( "data" : "T없2맑음" )
                            // 채팅명 초기화
                            this.chatName = json.getString("data");
                            // 클라이언트 정보 저장
                            chatServer.addSocketClient(this);
                            // 접속한 모든 클라이언트한테 수신정보 송신
                            chatServer.sendToAll(this, "들어오셨습니다.");
                            break;
                        case "message":
                            // 받은 채팅 메시지를 모든 클라이언트한테 뿌려주기
                            String message = json.getString("data");
                            chatServer.sendToAll(this, message);
                            break;
                        case "secret":
                            String secretClientName = json.getString("data");
                            String secretMessage = json.getString("secret_data");
                            chatServer.sendToOne(this, secretClientName, secretMessage);
                            break;
                    }

                    // 데이터 주고받는데... 이게 뭔뜻인지 ?
                    // {
                    //      "command" : "incoming";
                    // }
                    // "command"
                        // "incoming" - 처음 들어올 때
                        // "message" - 그 이후에 채팅 메시지

                }
            } catch (IOException e) {
                // 클라이언트가 나감
                    // 1. 나간 사실을 다른 클라이언트들에게 알려주기
                    // 2. 맵에서 클라이언트 제거
                chatServer.sendToAll(this, "나가셨습니다.");
                chatServer.removeSocketClient(this);
            }

        });
    }

    public void send(String sendData) {
        try {
            dos.writeUTF(sendData);
            dos.flush();
        } catch (IOException e) {

        }
    }
}
