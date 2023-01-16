package chap03;

public class BinaryOperator5 {
    public static void main(String[] args) {
        // 비교 연산자
        // 결과: boolean
        //
        System.out.println(1>3);
        System.out.println(1==1);
        System.out.println('a' < 'b'); // 유니코드로 변환해서 비교
        System.out.println('a' < 110);

        //참조형 타입인 String인 경우 대소 비교 방식이 다름
        String str1 = new String("A");
        String str2 = new String("A");
        String str3 = "A";
        String str4 = "A";
        System.out.println(str1 == str2); //주소값을 비교
        System.out.println(str3 == str4);

        System.out.println(str1.equals(str2)); //값을 비교
        System.out.println(str3.equals(str4));





        // 실행중인 프로그램 = 프로세스
        // 컴퓨터 하드웨어 중 프로세스는 ㅇㄷ?
        // HDD vs RAM 누가빠르나
        // RAM: 프로세스가 적재되는 곳
        // 자바의 메모리 구조
         // 스택 영역, 힙 영역, 메소드 영역
         // 스택 영역: 지역변수, 파라미터 등
         // 힙: new로 생성된 객체가 저장되는 곳
         // 스택에서 힙영역의 주소값을 저장함


        System.out.println(1.0f ==1.0); //double로 변환후 비교

        double d = 0.1;
        float f = 0.1f;
        System.out.println(d == f); // 지정된 값 비교라 다름
        System.out.println( (double)f == d); // float은 double보다 정밀하지 못하기 때문에 변환해도 같을 수 없음



    }
}
