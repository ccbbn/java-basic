package chap05;

public class ArrayExample {
    public static void main(String[] args) {
        // 배열 타입
        // 10개의 커피를 담을 '컵' 변수를 선언해 보세요
        //
        String cup1 = "Americano";
        String cup2 = "케페라떼";
        //...

        String[] cups = {"아메리카노", "카페라떼", "카페모카", "에스프레소"};
        String cups1[];
        System.out.println(cups); // 주소값이 출려됨
        System.out.println(cups[1]);  // 0부터 시작함, 따라서 카페라떼 출력
        System.out.println(cups.length); // 사이즈는 한 번 정해지면 고정

        cups[3] = "레몬레이드";
        System.out.println(cups[3]);

    }
}
