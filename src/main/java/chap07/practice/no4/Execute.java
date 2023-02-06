package chap07.practice.no4;

import java.util.Scanner;


public class Execute {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Order orderBook = new Books();
        Order orderFood = new Food();
        Order orderElect = new Elect();


        orderBook.add();
        orderFood.add();
        orderElect.add();



        boolean run = true;
        while (run) {
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.println("1.상품추가 | 2.정보수정 | 3.삭제 | 4.상품명 조회 | 5.모든 상품 조회 | 6.상품 카테고리별 조회 | 7. 할인율 적용 | 0.종료");
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.print("선택> ");

            String selectNo = scanner.next();

            if (selectNo.equals("1")) {

                System.out.println("1: 도서추가 | 2: 식품추가 | 3: 전자기기추가 | *: 처음으로 돌아가기 ");
                boolean no1 = true;
                while (no1) {
                    System.out.print("선택> ");
                    String list = scanner.next();
                    switch (list) {
                        case "1":
                            System.out.println("도서 추가");
                            orderBook.insert();
                            no1 = false;
                            break;
                        case "2":
                            System.out.println("식품 추가");
                            orderFood.insert();
                            no1 = false;
                            break;
                        case "3":
                            System.out.println("전자기기 추가");
                            orderElect.insert();
                            no1 = false;
                            break;

                        case "*":
                            System.out.println("처음으로 돌아갑니다");
                            no1 = false;
                            break;

                        default:
                            System.out.println("존재하지 않는 카테고리 입니다. 다시 입력하세요");
                    }
                }

            } else if (selectNo.equals("2")) {

                System.out.println("찾는 상품이름을 적으세요 | *: 처음으로 돌아가기");
                System.out.print("찾는 것은?? : ");
                String findName = scanner.next();

                if (!findName.equals("*")) {
                    orderBook.find(findName);
                    orderFood.find(findName);
                    orderElect.find(findName);

                    System.out.print("바꿀이름은?? : ");
                    String change = scanner.next();

                    if(!change.equals("*")) {

                    // 도서 목록에서 찾아서 변경
                    orderBook.change(findName, change);

                    // 음식 목록에서 찾아서 변경
                    orderFood.change(findName, change);

                    // 전자기기 목록에서 찾아서 변경
                    orderElect.change(findName, change);

                    System.out.println(findName + "의 이름이 " + change + "으로 변경되었습니다.");
                    }
                }

            } else if (selectNo.equals("3")) {
                System.out.println("삭제할 상품이 있는 카테고리를 선택하세요");
                System.out.println("카테고리> 1: 도서 | 2: 식품 | 3: 전자기기 | *: 처음으로 돌아가기");
                boolean no3 = true;
                while (no3) {
                    System.out.print("카테고리 선택> ");

                    String cate = scanner.next();

                    switch (cate) {
                        case "1":
                            System.out.println("지울 책 이름을 적으세요 | *: 카테고리 재선택");
                            System.out.print("지울 책 이름은?? : ");
                            String bookName = scanner.next();

                            if (!bookName.equals("*")) {
                            orderBook.delete(bookName);
                            no3 = false;}
                            break;

                        case "2":
                            System.out.println("지울 음식 이름을 적으세요 | *: 카테고리 재선택");
                            System.out.print("지울 음식 이름은?? : ");
                            String foodName = scanner.next();

                            if(!foodName.equals("*")) {
                            orderFood.delete(foodName);
                            no3 = false;}
                            break;

                        case "3":
                            System.out.println("지울 전자기기 이름을 적으세요 | *: 카테고리 재선택");
                            System.out.print("지울 전자기기 이름은?? : ");
                            String electName = scanner.next();

                            if(!electName.equals("*")) {
                            orderElect.delete(electName);
                            no3 = false;}
                            break;

                        case "*":
                            System.out.println("처음으로 돌아갑니다");
                            no3 = false;
                            break;

                        default:
                            System.out.println("존재하지 않는 카테고리 입니다. 다시 입력하세요");

                    }
                }

            } else if (selectNo.equals("4")) {

                System.out.println("찾는 상품이름을 적으세요");
                System.out.print("찾는 것은?? : ");
                String findName = scanner.next();

                orderBook.find(findName);
                orderFood.find(findName);
                orderElect.find(findName);


            } else if (selectNo.equals("5")) {

                orderBook.allList();
                orderFood.allList();
                orderElect.allList();

            } else if (selectNo.equals("6")) {

                System.out.println("카테고리> 1: 도서 | 2: 식품 | 3: 전자기기 | *: 처음으로 돌아가기");
                boolean no6 = true;
                while(no6) {
                    System.out.print("카테고리 선택> ");
                    String list = scanner.next();
                    switch (list) {
                        case "1":
                            System.out.println("도서에 해당합니다");
                            orderBook.allList();
                            no6 = false;
                            break;

                        case "2":
                            System.out.println("식품에 해당합니다");
                            orderFood.allList();
                            no6 = false;
                            break;

                        case "3":
                            System.out.println("전자기기에 해당합니다");
                            orderElect.allList();
                            no6 = false;
                            break;

                        case "*":
                            System.out.println("처음으로 돌아갑니다");
                            no6 = false;
                            break;

                        default:
                            System.out.println("존재하지 않는 카테고리 입니다. 다시 입력하세요");
                    }
                }
            } else if (selectNo.equals("7")) {

                System.out.println("할인율을 적용할 상품이름을 적으세요");
                System.out.print("찾는 상품명은?? : ");

                String findName = scanner.next();

                orderBook.find(findName);
                orderFood.find(findName);
                orderElect.find(findName);

                System.out.println("적용할 할인율은? 할인율(%)은 10 ~ 90입니다");

                boolean no7 = true;
                 while(no7) {
                     System.out.print("입력> ");
                     int rate1 = scanner.nextInt();
                     if ((rate1 < 10) || (rate1 > 90)) {
                         System.out.println("할인율(%)은 10 ~ 90입니다. 다시 입력하세요");
                     } else {
                         orderBook.discount(findName, rate1);
                         orderFood.discount(findName, rate1);
                         orderElect.discount(findName, rate1);
                         System.out.println("가격변경 성공");
                         no7 = false;
                     }
                 }
            }

            else if (selectNo.equals("0")) {
                run = false;
            } else {
                System.out.println("존재하지 않는 카테고리 입니다. 다시 입력하세요");
            }
        }
        System.out.println("프로그램 종료");
    }

}
