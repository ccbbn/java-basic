package chap07.practice.no2;

import access.p1.B;
import chap06.check.extra.Bank;

import java.util.Scanner;
import java.util.SortedMap;


public class Excute {

    private static Scanner scanner = new Scanner(System.in);

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
                        System.out.println("도서 추가");
                        Books.inputBook();
                        break;
                    case "2":
                        System.out.println("식품 추가");
                        Food.inputFood();
                        break;
                    case "3":
                        System.out.println("전자기기 추가");
                        Elect.inputElect();
                        break;
                    default:
                        System.out.println("존재하지 않는 카테고리 입니다. 다시 입력하세요");
                }

            } else if (selectNo.equals("2")) {

                System.out.println("찾는 상품이름을 적으세요");
                System.out.print("찾는 것은?? : ");
                String findName = scanner.next();

                Books.findBookName(findName);
                Food.findFoodName(findName);
                Elect.findElectName(findName);

                System.out.print("바꿀이름은?");
                String change = scanner.next();

                // 도서 목록에서 찾아서 변경
                Books.changeBook(findName, change);

                // 음식 목록에서 찾아서 변경
                Food.changeFood(findName, change);

                // 전자기기 목록에서 찾아서 변경
                Elect.changeElect(findName, change);

                System.out.println(findName + "의 이름이 " + change + "으로 변경되었습니다.");


            } else if (selectNo.equals("3")) {
                System.out.println("삭제할 상품이 있는 카테고리를 선택하세요");
                System.out.println("카테고리> 1: 도서 | 2: 식품 | 3: 전자기기");
                System.out.print("카테고리 선택> ");

                String cate = scanner.next();

                if ((cate.equals("1")) || (cate.equals("2")) || (cate.equals("3"))) {

                    switch (cate) {
                        case "1":
                            System.out.println("지울 책 이름을 적으세요");
                            System.out.print("지울 책 이름은?? : ");
                            String bookName = scanner.next();
                            Books.removeBook(bookName);
                            break;

                        case "2":
                            System.out.println("지울 음식 이름을 적으세요");
                            System.out.print("지울 음식 이름은?? : ");
                            String foodName = scanner.next();
                            Food.removeFood(foodName);
                            break;

                        case "3":
                            System.out.println("지울 전자기기 이름을 적으세요");
                            System.out.print("지울 전자기기 이름은?? : ");
                            String electName = scanner.next();
                            Elect.removeElect(electName);
                            break;

                        default:
                            System.out.println("존재하지 않는 카테고리 입니다. 다시 입력하세요");

                    }
                } else {
                    System.out.println("존재하지 않는 카테고리 입니다. 다시 입력하세요");
                }

            } else if (selectNo.equals("4")) {

                System.out.println("찾는 상품이름을 적으세요");
                System.out.print("찾는 것은?? : ");
                String findName = scanner.next();

                Books.findBookName(findName);
                Food.findFoodName(findName);
                Elect.findElectName(findName);

            } else if (selectNo.equals("5")) {

                alllist();

            } else if (selectNo.equals("6")) {

                System.out.println("카테고리> 1: 도서 | 2: 식품 | 3: 전자기기");
                System.out.print("카테고리 선택> ");
                int list = scanner.nextInt();
                switch (list) {
                    case 1:
                        System.out.println("도서에 해당합니다");
                        Books.bookList();
                        break;
                    case 2:
                        System.out.println("식품에 해당합니다");
                        Food.foodList();
                        break;
                    case 3:
                        System.out.println("전자기기에 해당합니다");
                        Elect.electList();
                        break;
                    default:
                        System.out.println("존재하지 않는 카테고리 입니다. 다시 입력하세요");
                }

            } else if (selectNo.equals("0")) {
                run = false;
            } else {
                System.out.println("존재하지 않는 카테고리 입니다. 다시 입력하세요");
            }
        }
        System.out.println("프로그램 종료");
    }


    // 전체 목록 5
    private static void alllist() {
        Books.bookList();
        Food.foodList();
        Elect.electList();
    }



}

















