package chap05;

public class ArrayQuiz {
    public static void main(String[] args) {
        // 배열을 이용해서
        // 1 ~ 10까지의 숫자 10개를 랜덤으로 받아
        // 평균을 구하는 프로그램을 구현

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;
        for (int i = 0; i< numbers.length; i++) {
             sum += numbers[i];
        }
        System.out.println((double) sum/numbers.length);


        int[] Mean = new int[10];
        int sum2 = 0;
        for (int i = 0; i <=9; i++) {
            Mean[i] = (int)(Math.random()*10)+1;
        }
        for (int i = 0; i <=9; i++) {
            sum2 += Mean[i];
        }
        System.out.println((double) sum2/Mean.length);
    }
}

