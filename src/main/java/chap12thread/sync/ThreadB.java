package chap12thread.sync;

public class ThreadB extends Thread{

    private Cal cal;
    public ThreadB() {
        setName("ThreadB");
    }

    public void setCal(Cal cal){
        this.cal = cal;
    }

    @Override
    public void run() {
        cal.setMemory(50);
    }
}
