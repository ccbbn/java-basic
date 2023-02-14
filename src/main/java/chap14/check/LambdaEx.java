package chap14.check;

import java.util.function.IntBinaryOperator;

public class LambdaEx {
    private static int[] scores = {10, 50, 3};

    public static int maxOrMin(IntBinaryOperator operator) {
        int result = scores[0];
        for (int score : scores) {
            result = operator.applyAsInt(result, score);
        }
        return result;
    }

    public static void main(String[] args) {
        //최대값얻기
        int max = maxOrMin(
                (left, right) -> {
                    if(left < right) {return right;}
                    else {return left;}
                });
        System.out.println("최대값: " + max);

        int min = maxOrMin(
                (left, right) -> {
                    if(left < right) {return left;}
                    else {return right;}
                });// 람다식이 applyAsInt를 오버라이드 하는 것임
        System.out.println("최소값: " + min);
    }
}




