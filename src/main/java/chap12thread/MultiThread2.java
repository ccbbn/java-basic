package chap12thread;

import lombok.SneakyThrows;

public class MultiThread2 {

    @SneakyThrows
    public static void main(String[] args) {
        // 익명 자식 클래스
        Thread workThread = new Thread(){
            @SneakyThrows
            @Override
            public void run() {
                for(int i =0; i < 5 ; i++) {
                    System.out.println("extra");
                    Thread.sleep(500); // 0.5초
                }
            }
        };

        workThread.start();


    }
}
