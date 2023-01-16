package algorithm.basic;

import java.util.Scanner;

public class Max3 {
    public static void main(String[] args) {
        ///세 값의 최대값 구하기
        // 변수명은 a,b,c
        // 세 값은 사용자로부터 직접 입력받기
        // 입력한 세 값(a, b, c)중 가장 큰 수를 구한다

        //double a, b, c;
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if ( a > b && a > c) {
            System.out.println(a);
        } else if ( b > a && b > c) {
            System.out.println(b);
        } else if ( c > a && c > b) {
            System.out.println(c);
        }
        System.out.println(Math.max(Math.max(a,b),c));

        int max = (int) b;
        if ( a > b ) max = (int) a;
        if ( c > max ) max = (int) c;

        }
    // 매개변수로 int형 3개를 입력 받고
    // 출력(int)은 최대값을 출력할 수 잇드록 메소드 구현

    //리턴 타입, 매개변수 중요
    public static int max3Method(int a, int b, int c) {

        int max =  b; // 메소드 안의 지역변수
        if ( a > b ) max = a;
        if ( c > max ) max = c;

        return max;

    }

}
