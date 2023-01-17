package algorithm.basic.M;

import java.util.Scanner;

public class Med {
    public static void main(String[] args) {
        // 3개의 정수를 상용자로터 입력받고
        // 그 중간값을 구하라
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();


        System.out.println(med(a, b, c));


    }

    private static int med(int a, int b, int c) {
        int median = a;

        if (b >= c && c >= a) median = c;
        if (b <= c && c <= a) median = c;
        if (c <= b && b >= a) median = b;
        if (c >= b && b <= a) median = b;

        return median;

    }

}
