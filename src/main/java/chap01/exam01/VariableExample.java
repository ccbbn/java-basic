package chap01.exam01;

import org.w3c.dom.ls.LSOutput;

public class VariableExample {
    public static void main(String[] args) {
        System.out.println("hello world");
        // 타입 : int, char, long...
        // 변수 : "value"
        // 대입연산자 : =
        //변수 선언과 동시에 초기화( 변수 선언: int value, 초기화: =0)
        // 카멜 표기법에 따라 변수명 만들기
        //리터럴(값)에 맞는 변수 타입을 지정해야함
        // '' 문자 ""문자열
        int value = 10;
        double doubleValue = 10.1;
        char charValue ='c';
        String str = "string";
        boolean b = true;
        double c = 500.0;


        int value1;
        value1 = 20;


        System.out.println("value = "+10);
        System.out.println("value = "+ value);
        System.out.println(value1);






        double doubleValue2 = 2.5;
        int re = (int)(5+doubleValue2);
        System.out.println(re);

    }






}




