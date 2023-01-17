package chap05;

public class StringExample2 {
    public static void main(String[] args) {
        // String 타입
        String str = "HELLO";
        String str1 = new String("HELLO"); // 객체 생성

        System.out.println(str == str1);
        System.out.println(str.equals(str1)); // 주소가 아닌 값이 같은지 확인할 때

    }
}
