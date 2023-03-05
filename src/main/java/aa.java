import chap07.poly.ex1.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class aa {

    public static void main(String[] args) {

        int[][] x = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
        String[] spell = {"p", "o", "s"};
        String[] dic = {"sod", "eocd", "qixm", "adio", "soo"};
        solution(new String[]{"3 - 4 = -3", "5 + 6 = 11"}); // (3,-,4,+,5)


    }


    public int solution(int[][] dots) {

        int width = 0;
        int height = 0;

        for (int i = 0; i < dots.length; i++) {
            if (dots[0][1] == dots[i][1]) {
                width = dots[i][0] - dots[0][0];
            } else if (dots[0][0] == dots[i][0]) {
                height = dots[i][1] - dots[0][1];
            }
        }
        return Math.abs(width) * Math.abs(height);
    }
}
