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
        solution("3x + 7 + x");


    }

    public String solution(String polynomial) {
        String answer = "";
        String[] a = polynomial.split(" \\+ ");
        ArrayList<String> x = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        ArrayList<Integer> nx = new ArrayList<>();
        ArrayList<String> sum = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            if (a[i].contains("x")) {
                x.add(a[i]);
            } else
                c.add(Integer.parseInt(a[i]));
        }
        for (int i = 0; i < x.size(); i++) {
// 5x 1x 2x x
            5x 1 2x

            if (Objects.equals(x.get(i), "x")  ) {
                x.set(i, "1");
            } else if (Objects.equals(x.get(i), "1x")) {
                x.set(i, "1");
            }
            x.set(i, x.get(i).replaceAll("[^\\d]", ""));
            nx.add(Integer.parseInt(x.get(i)));
        }
        String xvalue = String.valueOf(nx.stream().mapToInt(Integer::intValue).sum());
        String cvalue = String.valueOf(c.stream().mapToInt(Integer::intValue).sum());

        if(xvalue.equals("0") && !cvalue.equals("0")) answer = cvalue;
        if(cvalue.equals("0") && !xvalue.equals("0")) answer = xvalue+"x";
        if(!cvalue.equals("0") && !xvalue.equals("0")) answer = xvalue+"x"+ " + " +cvalue;
        if(xvalue.equals("0") && cvalue.equals("0")) answer = "0";

        return answer;
        }
    }



