package algorithm.basic.loop;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        //a와 b 사이의 모든 정수의 합을구하시오

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        sumBetween(a, b);
        System.out.println(sumBetween(a, b));

        sumBetween2(a, b);
        System.out.println(sumBetween2(a, b));

    }

    private static int sumBetween2(int a, int b) {
        int sum = 0;
        if (a < b) {
            for (int i = a + 1; i <= b - 1; i++){
                sum += i;
            }
        }
        else {
            for (int i = b + 1; i <= a - 1; i++){
                sum += i;
            }
        }
        return sum;
    }

    private static int sumBetween(int a, int b) {
        int sum = 0;
        for (int i = a; i <= b; i++){
            sum += i;
        }
        return sum;
    }
}
