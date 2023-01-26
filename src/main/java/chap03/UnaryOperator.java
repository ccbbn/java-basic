package chap03;

public class UnaryOperator {
    public static void main(String[] args) {
        //+ - * / % > < % %  || !
        // 단항, 이항, 삼항
        // 피연산자(Operand)   증산비
        // 1+2: 2항
        // -1: 단항
        // 1 + "hello" -> 1hello
        // (70>60)? "true" : "false";   : 삼항

        byte bNum = 100;
        bNum = (byte) -bNum;
        // 연산 후 에 타입이 바뀐다.
        // 연산자 : input 1, 2, 3개
        // 함수: input 0...N 개

        // 증감 연산자
        int val =10;
        val++;
        System.out.println(val);    // 11
        val--;
        System.out.println(val);    // 10
        ++val;
        System.out.println(val);    // 11
        --val;
        System.out.println(val);    // 10


        System.out.println( ++val + 1);     // 12
        System.out.println(val);            // 11
        int res = val++ + 1;
        System.out.println(res);            // 12
        System.out.println(val);            // 12

        //논리 부정 연산자 (!)
        boolean b = !false;
        System.out.println(!b);     // false

        //비트 반전 연산자 : 정수 타입 (byte, short, int, long)
        //정수에서 최상위 비트는 부호를 가르킴(+ / -)

        int v = 10;
        // 00000000 00000000 00000000 00001010
        v =~v;
        // 10000000 00000000 00000000 00001010 음수는 -1부터 시작
        System.out.println(v);
        /*
        byte v = 10;
        // 00000000 00000000 00000000 00001010
        v = (byte) ~v;
        // 10000000 00000000 00000000 00001010 음수는 -1부터 시작
        System.out.println(v); */








    }
}
