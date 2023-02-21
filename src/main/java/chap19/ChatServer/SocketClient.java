package chap19.ChatServer;

import org.json.JSONObject;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

import static jdk.internal.org.jline.utils.Colors.s;


// 기조 기능에 추가 기능을 더하기 위해서 만든 클래스
public class SocketClient {

    ChatServer chatServer;
    Socket socket;

    DataInputStream dis;
    DataOutputStream dos;
    String clientIp;
    String chatName;


    public SocketClient(ChatServer chatServer, Socket socket){
        try {
            // 초기화
            this.chatServer = chatServer;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
            this.clientIp = isa.getHostName();

            // 스레드 풀에서 스레드 하나 가져와서 '데이터 송수신 작업' 처리
            receive();


        } catch (IOException e){
            e.printStackTrace();
        }

    }

    private void receive() {
        chatServer.threadPool.execute( () -> {

            try {
                while (true) {
                    // 데이터 수신
                    String receiveData = dis.readUTF();
                    // 데이터를 주고받는 데이터 타입 : JSON을 쓸거임

                    JSONObject json = new JSONObject(receiveData);

                    String command = json.getString("command");
                    switch (command) {
                        //처음 접속할 때
                        case "incoming" :
                            //채팅명이 담겨져 있음 ("data" : "ㅇㅅㅇ")
                            //채팅명 초기화
                            this.chatName = json.getString("data");
                            //클라이언트 정보 저장
                            // 접속한 모든 클라이언트한테 수신정보 송신
                            chatServer.addSocketClient(this);
                            // 접속한 모든 클라이언트한테 수신정보 송신
                            chatServer.sendToAll(this, "들어왔다");


                        case "message" :
                            // 받은 채팅 메시지를 모든클라이언트한테 뿌리기
                            String message = json.getString("data");
                            chatServer.sendToAll(this, message);
                            break;
                    }


                    // 데이터를주고 받는데..?
                    //{
                    //  "command " : "incoming";
                    //}
                    // "command" : ~~~
                        // "incoming"  - 처음 들어올 때
                        // "message" -

                }

            } catch (IOException e) {
                //클라이언트가 나감
                // 나간 사실을 다른 클라이언트들에게 알려주기
                //맵에서 클라이언트 제거

                chatServer.sendtoAll();
                chatServer.removeSocketClient();
            }


        });

    }

    public void send(String sendData) {
        try {
            dos.writeUTF(sendData);
            dos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
