package algorithm.basic.Array;

import java.util.Scanner;

public class ReverseArrayExample1 {
    public static void main(String[] args) {
        // 배열 요소에 값을 읽어서 역순으로 정렬

        Scanner sc = new Scanner(System.in);
        System.out.print("배열의 크기> ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + i + "] : ");
            arr[i] = sc.nextInt();
        }

        int[] rArr = new int[size];
        for (int i = 0 ; i < arr.length; i++) {
            rArr[i] = arr[size - i - 1]; // rArr의 정순은 arr의 역순, 크기가 5: rArr[0] = arr[4], rArr[1] = arr[3]....
            System.out.println("rArr [" + i + "] : " + rArr[i]) ;
        }


        // 배열을 역순으로 정렬 후 전체 배열 요소 출력
        // arr = reverseArr(arr);
        reverseArr2(arr);

//        int num = 50;
//        convertNumber(num);
//        System.out.println(num);

        for (int element : arr) {
            System.out.println(element);
        }
    }

    private static void convertNumber(int num) {
        num = 10000;
    }

    private static int[] reverseArr(int[] arr) {
        int[] reverseArr = new int[arr.length];
        // arr = {10, 20, 30, 40, 50}
        // reverseArr = {50, 40, 30, 20, 10}
        int i = arr.length - 1;
        for (int element : arr) {
            reverseArr[i] = element;
            i--;
        }
        return reverseArr;
    }





    // reverserArr2(arr)
    private static void reverseArr2(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            // swap
            // 맨 앞의 요소와 맨 뒤의 요소를 바꿔주세요
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    // System.arraycopy() <- 직접 구현
    private static void myArrayCopy
    (int[] src, int srcPos, int[] dest, int destPos, int length) {

    }
}