package chap09.check.Q6;

public class Chatting {
    void startChat(String chatId) {
        String nickName = null;
        nickName = chatId;
        String message = "여기에 초기화 필요";

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

    class Chat {
        void start() {}
        void sendMessage(String message) {}
    }
}


