package chap05;

import com.sun.source.tree.Scope;

import java.util.Scanner;

public class MultiArray {
    public static void main(String[] args) {
        int[][] scores = new int[2][3]; // 2*3 행렬
        //  수 영 국
        //  0  0  0
        //  0  0  0
        //         System.out.println(scores[0][1]); // 0,1
        //        System.out.println(scores[0]); // 행하나
        //

        Scanner sc = new Scanner(System.in);
        System.out.println(scores.length);
        System.out.println(scores[0].length);

        for (int i = 0; 0 < scores.length; i++) {
            System.out.println(i + "번 째 학생임");
            for (int j = 0; j < scores[0].length; j++) {
                scores[i][j] = sc.nextInt();
            }
        }
    }

}
