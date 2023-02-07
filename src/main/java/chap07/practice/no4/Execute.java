package chap07.practice.no4;

import java.util.Scanner;


public class Execute {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Order orderBook = new Books();
        Order orderFood = new Food();
        Order orderElect = new Elect();

        //// 기존에 저장된 자료들 불러오기
        orderBook.add();
        orderFood.add();
        orderElect.add();


        boolean run = true;
        while (run) {
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.println("1.상품추가 | 2.정보수정 | 3.삭제 | 4.상품명 조회 | 5.모든 상품 조회 | 6.상품 카테고리별 조회 | 7. 할인율 적용 | 0.종료");
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.print("선택> ");

            String selectNo = scanner.next();//메뉴 선택

            if (selectNo.equals("1")) {
                // 상품추가
                System.out.println("1: 도서추가 | 2: 식품추가 | 3: 전자기기추가 | *: 처음으로 돌아가기 ");

                boolean stayPage = true;
                while (stayPage) {
                    System.out.print("선택> ");
                    String list = scanner.next();
                    switch (list) {
                        case "1":
                            System.out.println("도서 추가");
                            orderBook.insert();
                            stayPage = false;
                            break;
                        case "2":
                            System.out.println("식품 추가");
                            orderFood.insert();
                            stayPage = false;
                            break;
                        case "3":
                            System.out.println("전자기기 추가");
                            orderElect.insert();
                            stayPage = false;
                            break;

                        case "*":
                            System.out.println("처음으로 돌아갑니다");
                            stayPage = false;
                            break;

                        default:
                            System.out.println("존재하지 않는 카테고리 입니다. 다시 입력하세요");
                    }
                }

            } else if (selectNo.equals("2")) {
                // 상품이름을 찾아서 수정
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
                // 상품이름으로 찾아서 삭제
                System.out.println("삭제할 상품이 있는 카테고리를 선택하세요");
                System.out.println("카테고리> 1: 도서 | 2: 식품 | 3: 전자기기 | *: 처음으로 돌아가기");
                boolean stayPage = true;
                while (stayPage) {
                    System.out.print("카테고리 선택> ");

                    String category = scanner.next();

                    switch (category) {
                        case "1":
                            System.out.println("지울 책 이름을 적으세요 | *: 카테고리 재선택");
                            System.out.print("지울 책 이름은?? : ");
                            String bookName = scanner.next();

                            if (!bookName.equals("*")) {
                            orderBook.delete(bookName);
                            stayPage = false;}
                            break;

                        case "2":
                            System.out.println("지울 음식 이름을 적으세요 | *: 카테고리 재선택");
                            System.out.print("지울 음식 이름은?? : ");
                            String foodName = scanner.next();

                            if(!foodName.equals("*")) {
                            orderFood.delete(foodName);
                            stayPage = false;}
                            break;

                        case "3":
                            System.out.println("지울 전자기기 이름을 적으세요 | *: 카테고리 재선택");
                            System.out.print("지울 전자기기 이름은?? : ");
                            String electName = scanner.next();

                            if(!electName.equals("*")) {
                            orderElect.delete(electName);
                            stayPage = false;}
                            break;

                        case "*":
                            System.out.println("처음으로 돌아갑니다");
                            stayPage = false;
                            break;

                        default:
                            System.out.println("존재하지 않는 카테고리 입니다. 다시 입력하세요");

                    }
                }

            } else if (selectNo.equals("4")) {
                //
                System.out.println("찾는 상품이름을 적으세요");
                System.out.print("찾는 것은?? : ");
                String findName = scanner.next();

                orderBook.find(findName);
                orderFood.find(findName);
                orderElect.find(findName);


            } else if (selectNo.equals("5")) {
                // 모든 상품을 조회
                orderBook.allList();
                orderFood.allList();
                orderElect.allList();

            } else if (selectNo.equals("6")) {
                // 카테 고리별 상품 조회
                System.out.println("카테고리> 1: 도서 | 2: 식품 | 3: 전자기기 | *: 처음으로 돌아가기");
                boolean stayPage = true;
                while(stayPage) {
                    System.out.print("카테고리 선택> ");
                    String list = scanner.next();
                    switch (list) {
                        case "1":
                            System.out.println("도서에 해당합니다");
                            orderBook.allList();
                            stayPage = false;
                            break;

                        case "2":
                            System.out.println("식품에 해당합니다");
                            orderFood.allList();
                            stayPage = false;
                            break;

                        case "3":
                            System.out.println("전자기기에 해당합니다");
                            orderElect.allList();
                            stayPage = false;
                            break;

                        case "*":
                            System.out.println("처음으로 돌아갑니다");
                            stayPage = false;
                            break;

                        default:
                            System.out.println("존재하지 않는 카테고리 입니다. 다시 입력하세요");
                    }
                }
            } else if (selectNo.equals("7")) {
                // 상품이름으로 찾아서 할인율을 적용한 가격 재조정
                System.out.println("할인율을 적용할 상품이름을 적으세요");
                System.out.print("찾는 상품명은?? : ");

                String findName = scanner.next();

                orderBook.find(findName);
                orderFood.find(findName);
                orderElect.find(findName);

                System.out.println("적용할 할인율은? 할인율(%)은 10 ~ 90입니다");

                boolean stayPage = true;
                 while(stayPage) {
                     System.out.print("입력> ");
                     int rate = scanner.nextInt();
                     if ((rate < 10) || (rate > 90)) {
                         System.out.println("할인율(%)은 10 ~ 90입니다. 다시 입력하세요");
                     } else {
                         orderBook.discount(findName, rate);
                         orderFood.discount(findName, rate);
                         orderElect.discount(findName, rate);
                         System.out.println("가격변경 성공");
                         stayPage = false;
                     }
                 }
            }

            else if (selectNo.equals("0")) {
                // 전체 작업 완료
                run = false;
            } else {
                System.out.println("존재하지 않는 카테고리 입니다. 다시 입력하세요");
            }
        }
        System.out.println("프로그램 종료");
    }




}
