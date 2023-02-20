package chap12thread.sync;

public class SyncCal {
    public static void main(String[] args) {
        // 공유 객체
        Cal cal = new Cal();

        ThreadA threadA = new ThreadA();
        threadA.setCal(cal);
        threadA.start();

        ThreadB threadB = new ThreadB();
        threadB.setCal(cal);
        threadB.start();




    }
}
