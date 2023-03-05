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


    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int x = 0;
        int y = 0;
        int z = 0;


        for (int i = 0; i < quiz.length; i++) {

            String[] arrayQuiz = quiz[i].split(" ");

            //x>0

            x = Integer.parseInt(arrayQuiz[0]);

            if (arrayQuiz[1].equals("-")) {
                y = -1 * Integer.parseInt(arrayQuiz[2]);
            } else {
                y = Integer.parseInt(arrayQuiz[2]);
            }

            z = Integer.parseInt(arrayQuiz[4]);


            if (x + y == z) {
                answer[i] = "O";
            } else {
                answer[i] = "X";
            }

        } return answer;

    }
}

