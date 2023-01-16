package chap03;

import javax.sound.midi.Soundbank;

public class BinaryOperator {
    public static void main(String[] args) {
        //이항 연산자
        //피연산자가 2개인 연산자
        //산술연산자, 문자를 연결 연산자, 대입 연산자, 비교 연산자, 논리 연산자,....
        /*
        산술 연산자
        - 산술 연산 시 타입에 주의
         */
        double b1 = 10;
        float b2 = 20;
        double b = b1 + b2;//jvm이 연산 시 32비트 단위로 계산

        int v1 = 5;
        int v2 = 2;
        int c = 65;

        System.out.println(v1 + v2);
        System.out.println(v1 - v2);
        System.out.println(v1 * v2);
        System.out.println((double) v1 / v2);
        System.out.println(v1 % v2);

        System.out.println(c + 1);
        System.out.println(c + '1');
        System.out.println((char) (c + '1'));

        //연산시 오버플로우 발생에 유의
        int n1 = 10000000;
        int n2 = 20000000;
        double i = n1 * n2;
        System.out.println(i);

        // 오버플로우 미리 탐지

        safem(n1, n2);

    }

    //void는 리턴 타입
    private static int safem(long n1, long n2) {
        if (n1 * n2 > Integer.MAX_VALUE) {
            System.out.println("오버플로우 발생");
            return 0; // 종료
            //throw new ArithmeticException("오버플로우 발생");
        }
        return (int) (n1 * n2);
    }



    private static int safem(double n1, double n2) {
        if (n1 * n2 > Integer.MAX_VALUE) {
            throw new ArithmeticException("오버플로우 발생");
        }
        return (int) (n1 * n2);


    }
}





