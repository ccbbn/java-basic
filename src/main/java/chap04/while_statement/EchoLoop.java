package chap04.while_statement;

import java.util.Scanner;

public class EchoLoop {
    public static void main(String[] args) {
        System.out.println("메시지 입력");
        System.out.println("프로그램 종료하라면 q를 입력");

        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println(">");
            input =scanner.nextLine();
            System.out.println(input);
        } while (!input.equals("q"));


    }
}
