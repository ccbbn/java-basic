package chap12thread.sync;

import lombok.SneakyThrows;

public class Cal {
    // 공유 필드
    private int memory;
    public int getMemory() {return memory;}
    @SneakyThrows
    public synchronized void setMemory(int memory) {
        this.memory = memory;

        Thread.sleep(2000);

        System.out.println(Thread.currentThread().getName() + "가 메모리를" + this.memory + "으로 변경");
    }
}
