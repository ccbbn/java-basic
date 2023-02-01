package chap07.practice.no3;

import chap07.practice.no2.Product;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Exam {
    private static Scanner scanner = new Scanner(System.in);
    private static chap07.practice.no2.Product[] basket = new Product[100];

    static int a = 0;

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("1.상품추가 | 2.정보수정 | 3.삭제 | 4.상품명 조회 | 5.모든 상품 조회 | 6.상품 카테고리별 조회 | 0.종료");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.print("선택> ");

            String selectNo = scanner.next();

            if (selectNo.equals("1")) {

                System.out.println("1: 도서추가 | 2: 식품추가 | 3: 전자기기추가");
                System.out.print("선택> ");
                String list = scanner.next();
                switch (list) {
                    case "1":
                        System.out.println("상품 추가");
                        System.out.print("상품ID: ");
                        int id1 = ThreadLocalRandom.current().nextInt(100000, 1000000);
                        System.out.println(id1);

                        System.out.print("상품명: ");
                        String name1 = scanner.next();

                        System.out.print("가격: ");
                        int price1 = scanner.nextInt();

                        System.out.print("재고: ");
                        int stock1 = scanner.nextInt();

                        System.out.print("저자: ");
                        String writer = scanner.next();

                        System.out.print("isbn: ");
                        int isbn = scanner.nextInt();

                        System.out.println("-----입력완료-----");

                        basket[a] = new Books(id1, name1, price1, stock1, writer, isbn);
                        a++;
                        break;

                    case "2":
                        System.out.println("식품 추가");
                        System.out.print("상품ID: ");
                        int id2 = ThreadLocalRandom.current().nextInt(100000, 1000000);
                        System.out.println(id2);

                        System.out.print("상품명: ");
                        String name2 = scanner.next();

                        System.out.print("가격: ");
                        int price2 = scanner.nextInt();

                        System.out.print("재고: ");
                        int stock2 = scanner.nextInt();

                        System.out.print("제조일자: ");
                        LocalDate made = LocalDate.now();
                        System.out.println(made);

                        System.out.print("유통기한: ");
                        LocalDate limitation = LocalDate.now().plusYears(1);
                        System.out.println(limitation);

                        System.out.println("-----입력완료-----");

                        basket[a] = new Food(id2, name2, price2, stock2, made, limitation);
                        a++;
                        break;

                    case "3":
                        System.out.print("상품ID: ");
                        int id3 = ThreadLocalRandom.current().nextInt(100000, 1000000);
                        System.out.println(id3);

                        System.out.print("상품명: ");
                        String name3 = scanner.next();

                        System.out.print("가격: ");
                        int price3 = scanner.nextInt();

                        System.out.print("재고: ");
                        int stock3 = scanner.nextInt();

                        System.out.print("제조사: ");
                        String com = scanner.next();

                        System.out.print("색: ");
                        String col = scanner.next();

                        System.out.println("-----입력완료-----");

                        basket[a] = new Elect(id3, name3, price3, stock3, com, col);
                        a++;
                        break;

                    default:
                        System.out.println("잘못 누르셨습니다. 1,2,3 중에 입력하세요");
                }

            } else if (selectNo.equals("5")){
                System.out.println("도서 출력");
                System.out.println(" [1]도서id     [2]도서이름     [3]도서가격    [4]도서재고   [5]도서작가    [6]도서Isbn|" );
                System.out.println("---------------------------------------------------------------------------------");
                for (Product value : basket) {
                    if (value != null) {
                        System.out.print("[1] " + value.getId());
                        System.out.print("      ");
                        System.out.print("[2] " + value.getName());
                        System.out.print("      ");
                        System.out.print("[3] " + value.getPrice());
                        System.out.print("      ");
                        System.out.print("[4] " + value.getStock());
                        System.out.print("      ");
                        System.out.print("[5] " + ((Books) value).getWriter());
                        System.out.print("      ");
                        System.out.print("[6] " + ((Books) value).getIsbn());
                        System.out.println("      ");
                        System.out.println("-------------------------------------------------------------------------");
                    }
                }

                System.out.println("식품 출력");
                System.out.println(" [1]식품id     [2]식품이름     [3]식품가격    [4]식품재고   [5]제조일    [6]유통기한|" );
                System.out.println("---------------------------------------------------------------------------------");
                for (Product product : basket) {
                    if (product != null) {
                        System.out.print("[1] " + product.getId());
                        System.out.print("      ");
                        System.out.print("[2] " + product.getName());
                        System.out.print("      ");
                        System.out.print("[3] " + product.getPrice());
                        System.out.print("      ");
                        System.out.print("[4] " + product.getStock());
                        System.out.print("      ");
                        System.out.print("[5] " + ((Food) product).made);
                        System.out.print("      ");
                        System.out.print("[6] " + ((Food) product).limitation);
                        System.out.println("      ");
                        System.out.println("-------------------------------------------------------------------------");
                    }
                }




            }
        }
    }
}





