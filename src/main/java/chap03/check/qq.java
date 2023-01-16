package chap03.check;

public class qq {
    public static void main(String[] args) {
        char n = 105;
        if (n > 100) {
            System.out.println("100보다 큰 숫자입니다.");
        }

        // 문제1
        // if 조건문 안의 코드를 삼항 조건 연산자로 바꿔보세요. 같은 결과 나오게
        System.out.println(n > 100 ? "100보다 큰 숫자입니다." : "");

        // 문제2
        // if 조건문 안의 코드를 && 연산자와 메소드를 이용해 같은 결과가 나오게 바꾸기

    }
}
