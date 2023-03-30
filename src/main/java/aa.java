import chap07.poly.ex7.Parent;

import java.util.*;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.lang.Long.toBinaryString;


public class aa {
    public static void main(String[] args) {


    String my_str = "abc1Addfggg4556b";
    solution(12, 21);




    }

    public static void solution(int a, int b) {
        int answer = 0;
        int com = 0;
        for (int i = a; i > 1; i--) {
            if (b % a == 0) {
                com = a;
                break;
            }
        }

        int denom = 0;
        if (com == 0) {  // ex 21
            while (b > 1) {
                if (b % 2 == 0) {
                    b /= 2;
                    continue;
                } else if (b % 5 == 0) {
                    b /= 5;
                    continue;
                }
                break;
            }

        } else { //ex 20

            denom = b / com;
            while (denom > 1) {
                if (denom % 2 == 0) {
                    denom /= 2;
                    continue;
                } else if (denom % 5 == 0) {
                    denom /= 5;
                    continue;
                }
                break;
            }

        }

        if (com == 0 && b == 1) {
            answer = 1;
        } else if (com != 0 && denom == 1) {
            answer = 1;
        } else
            answer = 2;


        System.out.println(answer);


    }
}



