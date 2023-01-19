package algorithm.basic.Array;

import java.util.Arrays;
import java.util.Scanner;

public class MultiArray {
    public static void main(String[] args) {
        // 메소드, 배열 다루기
        // 매개변수로 int형 배열과 정수를 받고
        // 받은 정수만큼 모든 배열의 요소를 곱해주는 메서드를 만들어주세요

        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[arr.length];


        System.out.println("배수를 입력하세요");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

       // multiplyArray(arr, n);
        multiplyArray2(arr2, n, arr);
        multipleArray3(arr, n);


/*
        for (int element : arr) {
            System.out.println(element);
        }*/

        System.out.println("새로운 배열 arr2");
        for (int element : arr2) {
            System.out.println(element);
        }

        int[] ints = multipleArray3(arr, n);
        System.out.println(Arrays.toString(ints));
    }

    private static void multiplyArray2(int[] arr2, int n, int[] arr) {
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[i] * n;
        }
    }

/*
    private static void multiplyArray(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * n;
        }
    }*/
    private static int[] multipleArray3(int[] arr, int n) {
        int[] arr3 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr3[i] = arr[i] * n;
        }
        return arr3;
    }

}
