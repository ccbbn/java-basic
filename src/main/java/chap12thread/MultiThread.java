package chap12thread;

import lombok.SneakyThrows;

import java.awt.*;

public class MultiThread {
    @SneakyThrows
    public static void main(String[] args) {
        // 스레드 작업 : new 스레드 -> start() -> OS: 실행대기(runnable) <-> 실행 -> 일시정지 -> 실행대기(runnable) -> 실행 -> 종료
        // 멀티 스레드 하는법: 1. 스레드 객체를 만든다. 2. 익명구현객체를 만든다 3.오버라이드해서 원하는 작업을 오버라이드한다.
        // 메인 스레드
        // 추가 스레드 : workThread
        Thread workThread = new Thread(new Runnable() {   //구현객체 필요
            @SneakyThrows
            @Override
            public void run() {
                //스레드에게 명령할 작업
                for(int i =0; i < 5 ; i++){
                    System.out.println("extra");
                    Thread.sleep(500); // 0.5초
                }
            }
        });
        workThread.start(); // 추가스레드 실행

        // 메인 스레드
        for(int i =0; i < 5 ; i++){
            System.out.println("main");
            Thread.sleep(500);
        }


    }

}
