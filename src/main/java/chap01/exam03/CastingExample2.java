package chap01.exam03;

public class CastingExample2 {
    public static void main(String[] args) {
        byte byteValue1 = 10;
        byte byteValue2 = 20;
        //byte byteValue3 = byteValue1 + byteValue2; //합의 결과는 int타입
        //byte byteValue3 = byte(byteValue1 + byteValue2); 정수를 byte로 강제 타입 변환
        long byteValue3 = byteValue1 +byteValue2; // 정수가 long으로 자동 타입 변환
        System.out.println(byteValue1 +byteValue2);


        char charValue1 = 'A'; // 65
        char charValue2 = 1;
        char charValue3 = (char)(charValue1 + charValue2); // 66 -> 'B'
        System.out.println(charValue3);

        int intValue = 10;
        int result = intValue/4;  // 계산은 2.5지만, int라서 2로나옴
        //int result= intValue/10.0; intValue/10.0은 double임, 큰 쪽으로 감
        //int result = (int)(intValue/4.0);


        System.out.println(result);



    }
}
