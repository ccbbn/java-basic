package algorithm.basic.loop;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("n값: ");
        int n = input.nextInt();

        System.out.print("w값: ");
        int w = input.nextInt();


        if (n >= w) {

            printStar(n, w);

        } else {
            System.out.println("w가 더 큽니다.");
            System.out.print("w값: ");
            w = input.nextInt();

            printStar(n, w);

        }

    }

    private static void printStar(int n, int w) {
        int division = n / w;
        int remainder = n % w;

        for (int i = 1; i <= division; i++) {
            for (int j = 1; j <= w; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int k = 1; k <= remainder; k++) {
            System.out.print("*");
        }
    }
}
