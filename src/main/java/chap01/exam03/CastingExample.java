package chap01.exam03;

public class CastingExample {
    public static void main(String[] args) {
        // 타입 변환
        // 자동 vs 강제
        int var = 12844; // byte의 허용범위 -128~127
        // 10101010 10101010 10101010 10101011 : int
        // 00000000 : byte
        // int -> byte 강제 형변환 시 데이터 손실이 일어남
        // 10101011 : byte

        byte var1 = (byte) var;
        System.out.println(var1);


        int i = -130;
        // byte : 원시 타입
        // Byte : 객체 타입의 byte
        // -128 보다 커야하고 127 보다 작아야한다
        // and(%%), or(||)
        if((i < Byte.MIN_VALUE) || (i > Byte.MAX_VALUE )) {
            System.out.println("값을 변환할 수 없음");
        }else{
            byte b = (byte) i;
            System.out.println(b);
        }

        // 정수를 실수
        // int : 4바이트, float ; 4바이트, double : 8바이트
        int num1 = 1234567890;
        int num2 = 1234567890;

        float num3 = num2; // 자동 형변환
        num2 = (int)num3;

        int result = num1-num2;
        System.out.println(result);// 0이 아님, 타입변환 시 데이터 손실이 생겼기 때문, double은 크기가 커서 손실이 적어 0이 나옴



    }
}
