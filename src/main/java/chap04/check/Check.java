package chap04.check;

import java.util.Scanner;

public class Check {
    public static void main(String[] args) {

        int i;
        int sum =0;
        for(i = 1; i<=100; i++){
            if(i%3==0){
                sum = sum +i;
            }
        }
        System.out.println("3의 배수의 합: " + sum);


        int a=0;
        int b=0;

        while(a+b!=5) {
            a = (int) (Math.random() * 6) + 1;
            b = (int) (Math.random() * 6) + 1;

            System.out.println("(" + a + ", " + b + ")");
        }


        int x;
        int y;
        for(x=1; x<=10; x++){
            for(y=1; y<=10; y++){
                if(4*x+5*y==60){
                    System.out.println("(" +x+", "+y+")");
                }
            }
        }
        for (int q = 1; q <= 5; q++) {
            for (int p = 0; p < q; p++) {
                System.out.println("*");
            }
            System.out.println();
        }




        int x1;
        for(x1=1; x1<=5; x1++){
            switch (x1){
                case 1:
                    System.out.println("*");
                    break;
                case 2:
                    System.out.println("**");
                    break;
                case 3:
                    System.out.println("***");
                    break;
                case 4:
                    System.out.println("****");
                    break;
                case 5:
                    System.out.println("*****");
                    break;
                }
            }

        boolean run = true;
        int balance = 0;
        Scanner scanner = new Scanner(System.in);
        while (run){
            System.out.println("----------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("----------------------------");
            System.out.println("선택> ");

            int input = Integer.parseInt(scanner.nextLine());


            switch (input){
                case 1 :
                    System.out.println("예금액> ");
                    balance += Integer.parseInt(scanner.nextLine());
                    break;
                case 2 :
                    System.out.println("출금액> ");
                    balance -= Integer.parseInt(scanner.nextLine());
                    break;
                case 3 :
                    System.out.println("잔고> " + balance);
                    break;
                case 4 :
                    run = false;
                    break;
            }
        }

        System.out.println("프로그램 종료");
        }
}
