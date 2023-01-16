package chap03;

public class BinaryOperator8 {
    public static void main(String[] args) {
        int n = 3;
        n += 1;  //n = n +1
        n -= 1;  //n = n -1
        n*=2;
        n/=2;
        n%=2;
        n&=2;  // 1 & 2 -> 0
        System.out.println(n);
    }
}
