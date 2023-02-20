package chap12thread.sync;

public class ThreadA extends Thread {

    private Cal cal;
    public  ThreadA(){
        setName("ThreadA");  // Thread에 있는 함수
    }

    public void setCal(Cal cal){
        this.cal = cal;
    }


    @Override
    public void run() {
        cal.setMemory(100);
    }
}
