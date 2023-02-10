package chap11.ex06;

public class Wrap {
    public static void main(String[] args) {
        int n = 1; // 스택에 저장
        byte b = 2; //
        String s = "hello";

        Integer nWrapper = 1;
        Byte bWrapper = 2;


        nWrapper = n; // 박싱
        n = nWrapper;  // 언박실

        //Integer.getInteger(); 정적메소드
        //nWrapper.equals(); 인스턴트메소드
    }
}
