package chap19.B;


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


    public void game1(String answerToGame1){


    }

    public void game2(String answerToGame2){

    }


}
