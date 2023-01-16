package algorithm.basic.loop;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        // 1 ~ n까지 합을 구하는 프로그램
        // 합을 구하는 모든 과정
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.println("1부터 n까지의 합");

        System.out.println("n = ");
        n = sc.nextInt();

        int sum = 0;
        for (int i = 0; i <= n; i++){
            if (i < n)
                System.out.print(i + "+");
            else
                System.out.print(i + " = ");
            sum = sum + i;
        }
        System.out.println(sum);


        int sum1 = 0;
        for (int i = 0; i < n; i++){
            System.out.print(i + "+") ;
            sum1 = sum1 +i;
        }
        System.out.print(n);
        sum1 = sum1+n;
        System.out.print("=" + sum1);


    }
}
