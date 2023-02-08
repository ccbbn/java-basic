package chap07.practice.no5;

import java.util.Scanner;


public class Excute {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Books.addBook();
        Food.addFood();
        Elect.addElect();

        Discount changeFoodPrice = new Food();  //implements 객체


        boolean run = true;
        while (run) {
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.println("1.상품추가 | 2.정보수정 | 3.삭제 | 4.상품명 조회 | 5.모든 상품 조회 | 6.상품 카테고리별 조회 | 7. 할인율 적용 | 0.종료");
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.print("선택> ");

            String selectNo = scanner.next();

            if (selectNo.equals("1")) {

                System.out.println("1: 도서추가 | 2: 식품추가 | 3: 전자기기추가 | *: 처음으로 돌아가기 ");

                boolean stayPage = true;
                while (stayPage) {
                    System.out.print("선택> ");
                    String list = scanner.next();
                    switch (list) {
                        case "1":
                            System.out.println("도서 추가");
                            Books.insertBook();
                            stayPage = false;
                            break;
                        case "2":
                            System.out.println("식품 추가");
                            Food.insertFood();
                            stayPage = false;
                            break;
                        case "3":
                            System.out.println("전자기기 추가");
                            Elect.insertElect();
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

                System.out.println("찾는 상품이름을 적으세요 | *: 처음으로 돌아가기");
                System.out.print("찾는 것은?? : ");
                String findName = scanner.next();

                if (!findName.equals("*")) {

                    Books.findBookName(findName);
                    Food.findFoodName(findName);
                    Elect.findElectName(findName);

                    System.out.print("바꿀이름은?? : ");
                    String change = scanner.next();

                    if(!change.equals("*")) {

                        Books.changeBookName(findName, change);
                        Food.changeFoodName(findName, change);
                        Elect.changeElectName(findName, change);

                        System.out.println(findName + "의 이름이 " + change + "으로 변경되었습니다.");

                        }
                    }

            } else if (selectNo.equals("3")) {

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
                                Books.deleteBook(bookName);
                                stayPage = false;}

                            break;

                        case "2":
                            System.out.println("지울 음식 이름을 적으세요 | *: 카테고리 재선택");
                            System.out.print("지울 음식 이름은?? : ");
                            String foodName = scanner.next();

                            if(!foodName.equals("*")) {
                                Food.deleteFood(foodName);
                                stayPage = false;}

                            break;

                        case "3":
                            System.out.println("지울 전자기기 이름을 적으세요 | *: 카테고리 재선택");
                            System.out.print("지울 전자기기 이름은?? : ");
                            String electName = scanner.next();

                            if(!electName.equals("*")) {
                                Elect.deleteElect(electName);
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

                System.out.println("찾는 상품이름을 적으세요");
                System.out.print("찾는 것은?? : ");
                String findName = scanner.next();

                Books.findBookName(findName);
                Food.findFoodName(findName);
                Elect.findElectName(findName);

            } else if (selectNo.equals("5")) {

                alllist();

            } else if (selectNo.equals("6")) {

                System.out.println("카테고리> 1: 도서 | 2: 식품 | 3: 전자기기 | *: 처음으로 돌아가기");
                boolean stayPage = true;
                while(stayPage) {
                    System.out.print("카테고리 선택> ");
                    String list = scanner.next();
                    switch (list) {

                        case "1":
                            System.out.println("도서에 해당합니다");
                            Books.bookList();
                            stayPage = false;
                            break;

                        case "2":
                            System.out.println("식품에 해당합니다");
                            Food.foodList();
                            stayPage = false;
                            break;

                        case "3":
                            System.out.println("전자기기에 해당합니다");
                            Elect.electList();
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

                // 식품 목록보여주기
                //


                System.out.println("할인율을 적용할 식품 이름을 적으세요");
                System.out.print("찾는 식품명은?? : ");

                String findName = scanner.next();
                Food.findFoodName(findName);

                System.out.println("적용할 할인율은? 할인율(%)은 10 ~ 90입니다");

                boolean stayPage = true;
                while(stayPage) {
                    System.out.print("입력> ");
                    int rate = scanner.nextInt();
                    if ((rate < 10) || (rate > 90)) {
                        System.out.println("할인율(%)은 10 ~ 90입니다. 다시 입력하세요");
                    } else {
                        changeFoodPrice.setPriceByDiscountRate(findName, rate);
                        System.out.println("할인율 적용 성공");
                        stayPage = false;
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


    // 전체 목록 5
    private static void alllist() {
        Books.bookList();
        Food.foodList();
        Elect.electList();
    }



}

















