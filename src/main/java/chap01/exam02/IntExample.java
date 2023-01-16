package chap01.exam02;

public class IntExample {
    public static void main(String[] args) {
        int var1=10;
        int var2=012; // 맨앞에 0이 오면 8진수
        // 01234567 : 10(8진수) = 8(10진수)
        int var3= 0xA; // 맨앞에 0x가 오면 16진수

        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
    }
}
