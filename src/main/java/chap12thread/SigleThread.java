package chap12thread;

public class SigleThread {
    public static void main(String[] args) throws InterruptedException {

        for(int i =0; i < 5 ; i++){
            System.out.println("hello");
            Thread.sleep(500); // 0.5초
        }



        for(int i =0; i < 5 ; i++){
            System.out.println("Bye");
            Thread.sleep(500);
        }
    }
}
