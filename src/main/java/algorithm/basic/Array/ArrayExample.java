package algorithm.basic.Array;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public static void main(String[] args) {
        // 자료 구조??
        // 데이터 단위와 데이터 자체 사이의 물리적 또는 논리적인 관계
        // 자료를 효율적으로 사용할 수 있도록 데이터를 저장하는 방법

        //coffee 10종류를 담을 수 있는 컵을 만들어주세요
        //String[] cups = new String[10];

        //사람 수를 입력하면
        //랜덤하게 각 사람의 키를 생성해주고 130 ~ 190
        //각 사람의 키와 그 중 최댓값으 반환하는 프로그램

        //ex)
        //사람 수를 입력하세요
        // --> 5
        //키 값은 다음과 같습니다.
        //176
        //150
        //185
        //169
        //160
        //최댓값을 ~ 입니다.
        int input = 0;
        int[] arrayHeight = null;
        int max = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("사람 수를 입력하세요");
        System.out.print("---> ");

        input = scanner.nextInt();
        arrayHeight = new int[input];

        for (int i = 0; i < arrayHeight.length; i++) {
            int height = (int) (Math.random() * 190) + 1;
            //// 130이하를 범위 안에 들어가게 하기 math.random()*60 + 130
            if (height < 130 && height >= 100) {
                height += 30;
            } else if (height < 100 && height >= 40 ) {
                height += 90;
            } else if (height < 40 && height >= 10) {
                height += 120;
            } else if (height < 10) {
                height += 129;
            }
            arrayHeight[i] = height; //키 배열에 랜덤 키 넣기
        }
        // 키 배열 나열
        for (int i = 0; i < arrayHeight.length; i++) {
            System.out.println(arrayHeight[i]);
        }
        // 최댓값 출력
        for (int i = 0; i < arrayHeight.length; i++) {
            if (arrayHeight[i] > max) {
                max = arrayHeight[i];
            }
        }
        System.out.println("최댓값은 " + max + "입니다.");



        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] heights= new int[num];
        for (int i = 0; i < heights.length; i++)    {
            heights[i] = 130 + rand.nextInt(60);
            System.out.println((i+0)+"번째 사람 키" +heights[i]);
        }


    }
}
