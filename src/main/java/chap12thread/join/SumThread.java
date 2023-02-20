package chap12thread.join;

public class SumThread extends Thread {

        public static long sum;
        @Override
        public void run() {
            for (int i = 1; i <= 100; i++ ){
                sum += i;
            }
        }



}
