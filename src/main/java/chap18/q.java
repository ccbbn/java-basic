package chap18;

import java.util.Arrays;
import java.util.Scanner;

public class q {

    static Scanner scanner = new Scanner(System.in);
    static int a = (int) (Math.random() * 100 + 1);
    static int count = 10;

    public static void main(String[] args) {
        game();
    }
    private static void game() {
        while (count > 0) {
            System.out.print("숫자를 맞춰봐 : ");
            int insert = scanner.nextInt();
            if (insert > a) {
                System.out.println("down");
                count--;
                System.out.println("시도 횟수 : " + (10 - count));
                System.out.println("==========================");
            } else if (insert < a) {
                System.out.println("up");
                count--;
                System.out.println("시도 횟수 : " + (10 - count));
                System.out.println("==========================");
            } else {
                System.out.println("☆★☆★성공☆★☆★ ");
                System.out.println("시도 횟수 : " + (10 - count));
                System.out.println("==========================");
                count = -1;
            }
        }
        if (count == 0) {
            System.out.println("실패!");
            reGame();
        } else
            reGame();
    }

    private static void reGame() {
        boolean run = true;
        while (run){
            System.out.println("리겜 ㄱㄱ? y or n");
            String reGame = scanner.next();
            switch (reGame) {
                case "y":
                    System.out.println("리겜 고고");
                    a = (int) (Math.random() * 100 + 1);
                    count = 10;
                    game();
                    run = false;
                    break;

                case "n":
                    System.out.println("그만하자");
                    count = -1;
                    run = false;
                    break;

                default:
                    System.out.println("잘못 입력함");

            }
        }
    }

}