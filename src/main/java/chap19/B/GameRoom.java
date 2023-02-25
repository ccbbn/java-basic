package chap19.B;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameRoom {


    String RoomName;
    Map<String, SocketClient> GameMember = Collections.synchronizedMap((new HashMap<>()));

    public GameRoom(String roomName) {
        RoomName = roomName;
    }

    public String getRoomName() {
        return RoomName;
    }
}
