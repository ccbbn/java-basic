package chap07.practice.no2;

import access.p1.B;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Excute extends {

    private static Excute[] productArray = new Excute[100];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("------------------------------------");
            System.out.println("1.상품추가 | 2.정보수정 | 3.삭제 | 4.상품명 조회 | 5.모든 상품 조회 | 6.상품 카테고리별 조회 | 0.종료");
            System.out.println("------------------------------------");
            System.out.print("선택> ");

            int selectNo = scanner.nextInt();

            if (selectNo == 1) {
                System.out.println("1: 도서추가 | 2: 식품추가 | 3: 전자기기추가");
                System.out.print("선택> ");
                int list = scanner.nextInt();
                switch (list) {
                    case 1:
                        System.out.println("도서 추가");
                        intputBook();
                        break;
                    case 2:
                        System.out.println("식품 추가");
                        break;
                    case 3:
                        System.out.println("전자기기 추가");
                        break;
                }
            }
        }
    }


    int i = 0;
    private static void intputBook() {

        System.out.print("상품ID: ");
        int id = ThreadLocalRandom.current().nextInt(100000, 1000000);
        System.out.println(id);

        System.out.print("상품명: ");
        String name = scanner.next();
        System.out.print("가격: ");
        int price = scanner.nextInt();
        System.out.print("재고: ");
        int stock = scanner.nextInt();
        System.out.print("저자: ");
        String writer = scanner.next();
        System.out.print("isbn: ");
        int isbn = scanner.nextInt();

        System.out.println("-----입력완료-----");
        Product books = new Books(id, name, price, stock, writer, isbn);


    }


}
