package chap05.quiz;

public class Check1 {
    static  final int NUMBER = 1; // 전역변수
    public static void main(String[] args) {
       if(true) {
           int l_val = 1;  // 지역변수0
       }
       //System.out.println(l_val);
        f();

    }
    private static void f() {
    }

}
