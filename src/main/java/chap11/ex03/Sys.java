package chap11.ex03;

public class Sys {
    public static void main(String[] args) {
//        System.exit(9);
//        System.currentTimeMillis();
//        System.nanoTime();// 현재시간


        int sum = 0;

        long start = System.nanoTime();
        for(int i = 0; i <10000000; i++){
            for (int j = 0; j<100000; j++){
                sum += i;
            }
        }
        long end = System.nanoTime();

        System.out.println(end - start + " 걸린시간");
    }
}
