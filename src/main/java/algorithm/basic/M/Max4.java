package algorithm.basic.M;

import java.util.Scanner;

public class Max4 {
    public static void main(String[] args) {
        // 4개의 값 중 최대값을 구하는 로직을 구하시오
        // 4개의 값 중 최소값을 구하는 로직을 구하시오
        // 메소드를 호출해서 답을 구하시오

        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int d = input.nextInt();

       // int k = input.nextInt();


      // System.out.println(max4Method(a, b, c, d));
      // System.out.println(min4Method(a, b, c, d));
      //  System.out.println(minMax(a, b, c, d, k));
        System.out.println(minMax2(false, a, b, c, d));
        System.out.println(animal(0));

    }

    private static int max4Method(int a, int b, int c, int d) {

        int max = b;
        if (a > b) max = a;
        if (c > max) max = c;
        if (d > max) max = d;

        return max;
    }

    private static int min4Method(int a, int b, int c, int d) {

        int min = b;
        if (a < b) min = a;
        if (c < min) min = c;
        if (d < min) min = d;

        return min;
    }

/*
    public static int minMax(int a, int b, int c, int d, int k) {
        if (k==0) {
            return min4Method(a, b, c, d);
        } else if (k==1) {
            return max4Method(a, b, c, d);
        }
        return Integer.parseInt(null);
    }*/

    //minMax()
    // 매개 변수 4개 정수, max인지 min인지 구분하는 구분자 1개
    // 리턴 : min or max
    // minMax(max, a, b, c, d)


    public static int minMax2(boolean isMin, int a, int b, int c, int d) {
        if (isMin) {
            return min4Method(a, b, c, d);
        } else {
            return max4Method(a, b, c, d);
        }
    }


    public static String animal(int code){
        if (code == 0) {
            return "개";
        }
        if (code == 1) {
            return "말";
        }
        if (code == 2){
            return "고양이";
        }
        return null;
    }







}










