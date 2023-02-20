package chap12thread.join;

import lombok.SneakyThrows;

public class JoinEx {
    @SneakyThrows
    public static void main(String[] args) {
        // join : 다른 스레드의 실행이 끝날 때가지 자기는 일시정지

        Thread sumThread = new Thread();
        sumThread.start();

        sumThread.join(); //

        System.out.println(SumThread.sum);  //출력이 먼저일지, sum계산이 먼저일지 정해줘야함 -> join으로 메인스레드를 잠깐 멈춤

    }
}
