package algorithm.basic.loop;

import java.util.Scanner;

public class Ex3 {

    // *를 n개 출력하되 w개 마다 줄을 바꿔서 출력
    // n은 총 *수, w는 한줄에 들어가는 *수
    // n값보다 w가 크면 w 다시쓰라고 나오기 ("w값:")

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("n값 : ");
        int n= input.nextInt();

        System.out.print("w값 : ");
        int w =input.nextInt();

        int division = n/w;

        for (int i = 1; i <= division; i++){
            System.out.println(i);
        }




    }
}
