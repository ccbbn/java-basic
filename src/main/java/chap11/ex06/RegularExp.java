package chap11.ex06;

import chap08.Basic.Parent;

import java.util.regex.Pattern;

public class RegularExp {
    public static void main(String[] args) {
        // 정규 표현식
        // [a,b,c] 중 하나
        // \d  == [0-9] : 0~9까지 숫자
        // \s : 공백


        String regularExp = "[abc]\\d+";

        System.out.println(Pattern.matches(regularExp, "a101010"));



        String email = "\\w+@\\w+.com" ;//e메일 주소값을 검증할 수 있는 정규 표현식


    }


}
