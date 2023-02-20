package chap18;

import java.util.Arrays;

public class q {

    public static void main(String[] args) {

        int answer = 0;

        String num1 = Integer.toString(12345);

        String[] arr = num1.split("");

        for (int i = 0; i < num1.length(); i++) {
            answer += Integer.parseInt(arr[i]);

        }
        System.out.println(answer);
    }

}
