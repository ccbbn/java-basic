package chap09.check.Q6;

public class Chatting {

///////////////////매소드///////////////////
    void startChat(String chatId) {
        String nickName = null;
        nickName = chatId;
        String message = "1";

        Chat chat = new Chat(){
            @Override
            void start() {
                while(true){
                    String inputData = "하이";
                    sendMessage(message);
                }
            }
        };
        chat.start();
    }
///////////////////매소드/////////////////////////

///////////////내부 클래스///////////////
    class Chat {
        void start() {}
        void sendMessage(String message){};
    }
/////////////내부 클래스////////////////
}


