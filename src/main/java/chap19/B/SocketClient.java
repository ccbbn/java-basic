package chap19.B;

import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketClient {

    Server server;
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    String userIP;
    String userName;
    String message;
    String hostName;
    String gameType1;
    String roomName1;
    String gameStart;
    String gameStop;
    String chat;
    String out;
    String result;


    public SocketClient(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
            this.userIP = isa.getHostName();

            receive();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void receive() {
        server.threadPool.execute(() -> {
            try {
                while (true) {
                    String receiveData = dis.readUTF();

                    JSONObject json = new JSONObject(receiveData);
                    String command = json.getString("command");

                    switch (command) {
                        case "incoming" :
                            this.userName = json.getString("userName");
                            server.addSocketClient(this);
                            // 접속한 모든 클라이언트한테 수신정보 송신
                            server.sendToAll(this, "님이 들어오셨습니다.");
                            break;
                        case "messageToAll" :
                            // 받은 채팅 메시지를 모든 클라이언트한테 뿌려주기
                            String message = json.getString("message");
                            server.sendToAll(this, message);

                        case "createGameRoom1" :
                            this.hostName = json.getString("hostName");
                            this.gameType1 = json.getString("gameType1");
                            this.roomName1 = json.getString("roomName1");
                            server.createRoom1(hostName, gameType1, roomName1, this);
                            // 게임방 만들고
                            // 응답

                            break;

                        case "findGameRoom" :
                            this.userName = json.getString("userName");
                            this.gameType1 = json.getString("gameType1");
                            this.roomName1 = json.getString("roomName1");
                            break;

                        case "joinGameRoom" :
                            this.userName = json.getString("userName");
                            this.gameType1 = json.getString("gameType1");
                            this.roomName1 = json.getString("roomName1");
                            server.joinGameRoom(userName, roomName1);
                            break;

                        case "startGame" :
                            this.hostName = json.getString("hostName");
                            this.gameStart = json.getString("gameStart");
                            break;

                        case "gameStop" :
                            this.hostName = json.getString("hostName");
                            this.gameStop = json.getString("gameStop");
                            break;

                        case "chat" :
                            this.hostName = json.getString("hostName");
                            this.userName = json.getString("userName");
                            message = json.getString("message");
                            break;

                        case "out" :
                            this.hostName = json.getString("hostName");
                            this.userName = json.getString("userName");
                            message = json.getString("message");
                            break;

                        case "result" :
                            this.hostName = json.getString("hostName");
                            this.userName = json.getString("userName");
                            message = json.getString("message");
                            break;


                    }
                }
            } catch (IOException e) {
                server.sendToAll(this, "님이 나가셨습니다.");
                server.removeSocketClient(this);
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
