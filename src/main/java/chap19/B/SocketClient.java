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

    String hostIP;

    String userName;

    String message;



    String gameType1;

    String roomName1;

    String gameStart;

    String gameStop;

    String chat;

    String out;

    String result;



    String user;

    String host;

    String chatMemberName;

    String hostName;

    String playerName;








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

                            server.sendToLobby(this, "님이 들어오셨습니다.");

                            break;



                        case "chatRoomIncoming" :

                            this.chatMemberName = json.getString("userName");

                            server.addSocketClientToChatRoom(this);

                            server.sendToChatRoom(this, "이 채팅방에 입장했습니다.");

                            break;



                        case "createGameRoom" :

                            this.hostName = json.getString("userName");

                            String roomName = json.getString("roomName");

                            server.createGameRoom(this, roomName);

                            server.sendToGameRoom(this,"이 "+roomName+"에 입장했습니다.");

                            break;

                        case "joinGameRoom" :

                            this.playerName = json.getString("playerName");

                            String inputtedRoomName = json.getString("inputtedRoomName");

                            server.joinGameRoom(this, inputtedRoomName);

                            server.sendToJoinedGameRoom(this,"이 " + inputtedRoomName + "에 입장했습니다",inputtedRoomName);

                            break;




                        case "messageToAll" :

                            // 받은 채팅 메시지를 모든 클라이언트한테 뿌려주기

                            String message = json.getString("message");

                            server.sendToLobby(this, message);

                            break;



                        case "messageToChatMember" :

                            String messageToChatMember = json.getString("message");

                            server.sendToChatRoom(this,messageToChatMember);

                            break;



                        case "messageToGameRoom":

                            String messageToGameRoom = json.getString("message");

                            server.sendToGameRoom(this, messageToGameRoom);

                            break;

                        case "messageToJoinedGameRoom" :

                            String messageToJoinedGameRoom = json.getString("message");
                            String roomName1 = json.getString("inputtedRoomName");

                            server.sendToJoinedGameRoom(this, messageToJoinedGameRoom, roomName1);

                            break;

                        case "roomInfo" :

                            server.roomInfo();

                            break;

//                        case "checkRoomInfo" :
//                            this.userName = json.getString("userName");
//
//                            server.addSocketRoomInfo(this);
//
//                            break;










                        //server.createRoom1(hostName, gameType1, roomName1, this);

                        // 게임방 만들고

                        // 응답



//                            break;

//

//                        case "findGameRoom" :

//                            this.userName = json.getString("userName");

//                            this.gameType1 = json.getString("gameType1");

//                            this.roomName1 = json.getString("roomName1");

//                            break;

//

//                        case "joinGameRoom" :

//                            this.userName = json.getString("userName");

//                            this.gameType1 = json.getString("gameType1");

//                            this.roomName1 = json.getString("roomName1");

////                            server.joinGameRoom(userName, roomName1);

//                            break;

//

//                        case "startGame" :

//                            this.hostName = json.getString("hostName");

//                            this.gameStart = json.getString("gameStart");

//                            break;

//

//                        case "gameStop" :

//                            this.hostName = json.getString("hostName");

//                            this.gameStop = json.getString("gameStop");

//                            break;

//

//                        case "chat" :

//                            this.hostName = json.getString("hostName");

//                            this.userName = json.getString("userName");

//                            message = json.getString("message");

//                            break;

//

//                        case "out" :

//                            this.hostName = json.getString("hostName");

//                            this.userName = json.getString("userName");

//                            message = json.getString("message");

//                            break;

//

//                        case "result" :

//                            this.hostName = json.getString("hostName");

//                            this.userName = json.getString("userName");

//                            message = json.getString("message");

//                            break;





                    }

                }

            } catch (IOException e) {

                server.sendToLobby(this, "님이 나가셨습니다.");

                server.removeSocketClient(this);

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
