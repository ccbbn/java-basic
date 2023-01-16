package chap03;

import java.security.spec.RSAOtherPrimeInfo;

public class BinaryOperator7 {
    public static void main(String[] args) {
        // 비트 논리 연산: 비트 단위로 연산하는 단위

        //논리곱
        // a 0011 :3
        // b 0010 :2
        // a & b = 0010
        System.out.println(3&2); // 2진수로 변환해서 처리됨
        //논리합
        // a 0011 :3
        // b 0010 :2
        // a | b = 0011
        System.out.println(3|2);
        //배타적 논리합
        // a 0011 :3
        // b 0010 :2
        // a ^ b = 0001
        System.out.println(3^2);
        // 부정
        // 0011 : 3
        // 부호가 바뀌고 하나 더 늘어남
        System.out.println(~3);


        //비트 이동 연산
        // 0011 : 3
        // 0110 : 6
        System.out.println(3<<1);
        // 1100 : 12
        System.out.println(3<<2);
        // 0001 : 1
        System.out.println(3>>1);
        // 0000 : 0
        System.out.println(3>>2);

    }
}
