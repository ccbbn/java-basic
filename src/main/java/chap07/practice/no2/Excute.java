package chap07.practice.no2;

import access.p1.B;
import chap06.check.extra.Bank;

import java.util.Scanner;
import java.util.SortedMap;


public class Excute {

    private static Scanner scanner = new Scanner(System.in);
    static Product[] updatehall = new Product[1000];

    int p;
//updatehall[p++];


    //Product findbook = new Books(a,b,c,d,e,f);


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
                        System.out.println("잘못 누르셨습니다. 1,2,3 중에 입력하세요");
                }

            } else if (selectNo.equals("2")) {
//                      for (int i = 0; i <= updatehall.length; i++) {
//                        Product upBooks;
//                        if (Books.booksArray[i] != null) {
//                            upBooks = new Books(Books.booksArray[i].getId(),
//                                    Books.booksArray[i].getName(),
//                                    Books.booksArray[i].getPrice(),
//                                    Books.booksArray[i].getStock(),
//                                    Books.booksArray[i].getWriter(),
//                                    Books.booksArray[i].getIsbn());
//                            updatehall[i] = upBooks;
//
//                        }
                System.out.println("찾는 상품이름을 적으세요");
                System.out.print("찾는 것은?? : ");
                String pName = scanner.next();

                Books.findBookName(pName);
                Food.findFoodName(pName);
                Elect.findElectName(pName);

                System.out.println("바꿀이름은?");
                String change = scanner.next();

                // 도서 목록에서 찾아서 변경
                if (Books.booksArray[0] != null) {
                    for (int i = 0; i <= 10000; i++) {
                        if (Books.booksArray[i].getName().equals(pName)) {
                            Books.booksArray[i].setName(change);
                        }
                        break;
                    }
                }
                // 음식 목록에서 찾아서 변경
                if (Food.foodArray[0] != null) {
                    for (int i = 0; i <= 10000; i++) {
                        if (Food.foodArray[i].getName().equals(pName)) {
                            Food.foodArray[i].setName(change);
                        }
                        break;
                    }
                }
                // 전자기기 목록에서 찾아서 변경
                if (Elect.electsArray[0] != null) {
                    for (int i = 0; i <= 10000; i++) {
                        if (Elect.electsArray[i].getName().equals(pName)) {
                            Elect.electsArray[i].setName(change);
                        }
                        break;
                    }
                }


            } else if (selectNo.equals("3")) {
                System.out.println("삭제할 상품이 있는 카테고리를 선택하세요");
                System.out.println("카테고리> 1: 도서 | 2: 식품 | 3: 전자기기");
                System.out.print("카테고리 선택> ");

                String cate = scanner.next();
                switch (cate) {
                    case "1" :
                        System.out.println("지울 책 이름을 적으세요");
                        System.out.print("지울 책 이름은?? : ");
                        String pName1 = scanner.next();
                        Books.removeBook(pName1);

                    case "2" :
                        System.out.println("지울 음식 이름을 적으세요");
                        System.out.print("지울 음식 이름은?? : ");
                        String pName2 = scanner.next();
                        Food.removeFood(pName2);

                    case "3" :
                        System.out.println("지울 전자기기 이름을 적으세요");
                        System.out.print("지울 전자기기 이름은?? : ");
                        String pName3 = scanner.next();
                        Elect.removeElect(pName3);
                    default :
                        System.out.println("잘못 누르셨습니다. 1,2,3 중에 입력하세요");
                }

            } else if (selectNo.equals("4")) {

                System.out.println("찾는 상품이름을 적으세요");
                System.out.print("찾는 것은?? : ");
                String pName = scanner.next();

                Books.findBookName(pName);
                Food.findFoodName(pName);
                Elect.findElectName(pName);

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
                        System.out.println("존재하지 않는 카테고리입니다");
                }

            } else if (selectNo.equals("0")) {
                run = false;
            } else {
                System.out.println("유효한 입력번호가 아닙니다. 다시 입력하세요");
            }
        }
        System.out.println("프로그램 종료");
    }


    // 전체 목록 5
    private static void alllist() {
//        int i = 0;
//        //for 돌리고 i번 째가 null이면 출력안함 그외는 출역
//        while (Books.booksArray[i] != null) {
//            System.out.print(Books.booksArray[i].getId());
//            System.out.print("        ");
//            System.out.print(Books.booksArray[i].getName());
//            System.out.print("        ");
//            System.out.println(Books.booksArray[i].getWriter());
//            i++;
//        } System.out.println();
        Books.bookList();
        Food.foodList();
        Elect.electList();
    }

}

















