package chap07.practice.Total;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Excute {

    private static Scanner scanner = new Scanner(System.in);

    private static Product[] productList = new Product[100];


    public static void main(String[] args) {

        addInventory();

        boolean run = true;
        while (run) {
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.println("1.상품추가 | 2.정보수정 | 3.삭제 | 4.상품명 조회 | 5.모든 상품 조회 | 6.상품 카테고리별 조회 | 7. 할인율 적용 | 0.종료");
            System.out.println("---------------------------------------------------------------------------------------------------------");
            System.out.print("선택> ");

            String selectNo = scanner.next();

            if (selectNo.equals("1")) {
                selectMenu();
            } else if (selectNo.equals("2")) {
                findProduct();
            } else if (selectNo.equals("3")) {
                deleteProduct();
            } else if (selectNo.equals("4")) {

                System.out.println("찾는 상품이름을 적으세요");
                System.out.print("찾는 것은?? : ");
                String findName = scanner.next();
                findName(findName);

            } else if (selectNo.equals("5")) {
                alllist();
            } else if (selectNo.equals("6")) {
                eachList();
            } else if (selectNo.equals("7")) {

                Discount[] discountedList = planedList();
                System.out.print("할인 적용할 상품을 선택해주세요: ");
                Discount product = discountedList[scanner.nextInt()-1];
                System.out.print("적용할 할인율을 입력하세요(10~90): ");
                int discountRate = scanner.nextInt();
                applyDiscount(product, discountRate);


            } else if (selectNo.equals("0")) {
                run = false;
            } else {
                System.out.println("존재하지 않는 카테고리 입니다. 다시 입력하세요");
            }
        }
        System.out.println("프로그램 종료");
    }


    private static void addInventory() {
        int i = 0;
        productList[i++] = new Books(123123, "초밥왕", 8000, 10, "데라사와", 110100, Product.bookType);
        productList[i++] = new Books(223223, "정처기", 23000, 50, "윤영빈", 123692, Product.bookType);
        productList[i++] = new Books(533433, "구해줘", 18000, 100, "기욤뮈소", 545100, Product.bookType);
        productList[i++] = new Food(778978, "떡볶이", 3000, 100, LocalDate.now(), LocalDate.now().plusDays(30), Product.foodType);
        productList[i++] = new Food(123978, "라볶이", 4000, 100, LocalDate.now(), LocalDate.now().plusDays(20), Product.foodType);
        productList[i++] = new Food(123978, "소고기", 50000, 100, LocalDate.now(), LocalDate.now().plusDays(3), Product.foodType);
        productList[i++] = new Elect(878876, "스마트폰", 500000, 10, "삼성", "블랙", Product.electType);
        productList[i++] = new Elect(675665, "냉장고", 1800000, 5, "LG", "실버", Product.electType);
        productList[i] = new Elect(233277, "스피커", 200000, 5, "BOSE", "화이트", Product.electType);

    }

    public static void selectMenu() {
        System.out.println("1: 도서추가 | 2: 식품추가 | 3: 전자기기추가 | *: 처음으로 돌아가기 ");

        boolean stayPage = true;
        while (stayPage) {
            System.out.print("선택> ");
            String list = scanner.next();
            switch (list) {
                case "1":
                    System.out.println("도서 추가");
                    insertBook();
                    stayPage = false;
                    break;
                case "2":
                    System.out.println("식품 추가");
                    insertFood();
                    stayPage = false;
                    break;
                case "3":
                    System.out.println("전자기기 추가");
                    insertElect();
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
    }

    public static void insertBook() {

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

        Books books = new Books(id, name, price, stock, writer, isbn, Product.bookType);
        for (int i = 0; i <= productList.length; i++) {
            if (productList[i] == null) {
                productList[i] = books;
                break;
            }
        }
    }

    public static void insertFood() {

        System.out.print("상품ID: ");
        int id = ThreadLocalRandom.current().nextInt(100000, 1000000);
        System.out.println(id);

        System.out.print("상품명: ");
        String name = scanner.next();

        System.out.print("가격: ");
        int price = scanner.nextInt();

        System.out.print("재고: ");
        int stock = scanner.nextInt();

        System.out.print("제조일자: ");
        LocalDate made = LocalDate.now();
        System.out.println(made);

        System.out.print("유통기한: ");
        LocalDate limitation = LocalDate.now().plusYears(1);
        System.out.println(limitation);

        System.out.println("-----입력완료-----");


        Food food = new Food(id, name, price, stock, made, limitation, Product.foodType);
        for (int i = 0; i <= productList.length; i++) {
            if (productList[i] == null) {
                productList[i] = food;
                break;
            }
        }
    }

    public static void insertElect() {

        System.out.print("상품ID: ");
        int id = ThreadLocalRandom.current().nextInt(100000, 1000000);
        System.out.println(id);

        System.out.print("상품명: ");
        String name = scanner.next();

        System.out.print("가격: ");
        int price = scanner.nextInt();

        System.out.print("재고: ");
        int stock = scanner.nextInt();

        System.out.print("제조사: ");
        String com = scanner.next();

        System.out.print("색: ");
        String col = scanner.next();

        System.out.println("-----입력완료-----");

        Elect elect = new Elect(id, name, price, stock, com, col, Product.electType);
        for (int i = 0; i <= productList.length; i++) {
            if (productList[i] == null) {
                productList[i] = elect;
                break;
            }
        }
    }


    public static void changeName(String originName, String newName) {
        for (int i = 0; i < productList.length - 1; i++) {
            if (productList[i] != null) {
                if (productList[i].getName().equals(originName)) {
                    productList[i].setName(newName);
                }
            }
        }
    }

    public static void findProduct(){
        System.out.println("찾는 상품이름을 적으세요 | *: 처음으로 돌아가기");
        System.out.print("찾는 것은?? : ");
        String originName = scanner.next();

        if (!originName.equals("*")) {

            findName(originName);

            System.out.print("바꿀이름은?? : ");

            String newName = scanner.next();

            if (!newName.equals("*")) {
                changeName(originName, newName);
                System.out.println(originName + "의 이름이 " + newName + "으로 변경되었습니다.");
            }
        }
    }


    public static void deleteProduct() {
        System.out.println("지울 상품 이름을 적으세요 | *: 카테고리 재선택");
        System.out.print("지울 상품 이름은?? : ");
        String productName = scanner.next();
        for (int i = 0; i < productList.length - 1; i++) {
            if (productList[i] != null) {
                if (productList[i].getName().equals(productName)) {
                    productList[i] = null;
                }
            }
        }
    }

    public static void findName(String productName) {

        for (int i = 0; i < productList.length - 1; i++) {
            if (productList[i] != null && productList[i] instanceof Books) {
                if (productList[i].getName().equals(productName)) {
                    System.out.println("================이름이 " + productName + " 인 도서 정보==============");
                    System.out.println("상품id : " + productList[i].getId());
                    System.out.println("책이름 : " + productList[i].getName());
                    System.out.println("가격 : " + productList[i].getPrice());
                    System.out.println("작가 : " + ((Books) productList[i]).getWriter());
                }
            }

            if (productList[i] != null && productList[i] instanceof Food) {
                if (productList[i].getName().equals(productName)) {
                    System.out.println("================이름이 " + productName + " 인 음식 정보==============");
                    System.out.println("상품id : " + productList[i].getId());
                    System.out.println("음식이름 : " + productList[i].getName());
                    System.out.println("가격 : " + productList[i].getPrice());
                    System.out.println("제조일 : " + ((Food) productList[i]).getMade());
                    System.out.println("유통기한 : " + ((Food) productList[i]).getLimitation());
                }
            }

            if (productList[i] != null && productList[i] instanceof Elect) {
                if (productList[i].getName().equals(productName)) {
                    System.out.println("==============이름이 " + productName + " 인 전자기기 정보============");
                    System.out.println("상품id : " + productList[i].getId());
                    System.out.println("전자기기 이름: " + productList[i].getName());
                    System.out.println("전자기기 가격: " + productList[i].getPrice());
                    System.out.println("제조회사 : " + ((Elect) productList[i]).getCom());
                    System.out.println("색상 : " + ((Elect) productList[i]).getCol());
                }
            }
        }
    }

    private static void alllist(){
        bookList();
        foodList();
        electList();
    }

    private static void eachList() {
        System.out.println("카테고리> 1: 도서 | 2: 식품 | 3: 전자기기 | *: 처음으로 돌아가기");
        boolean stayPage = true;
        while (stayPage) {
            System.out.print("카테고리 선택> ");
            String list = scanner.next();
            switch (list) {

                case "1":
                    System.out.println("도서에 해당합니다");
                    bookList();
                    stayPage = false;
                    break;

                case "2":
                    System.out.println("식품에 해당합니다");
                    foodList();
                    stayPage = false;
                    break;

                case "3":
                    System.out.println("전자기기에 해당합니다");
                    electList();
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
    }

    private static void bookList() {
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■도서목록■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println("1: 상품id | 2: 상품명 | 3: 가격 | 4: 저자");
        System.out.println("=============================================================");
        for (int i = 0; i < productList.length - 1; i++) {
            if (productList[i] != null && productList[i] instanceof Books) {
                if (productList[i].getType() == Product.bookType) {
                    System.out.print(productList[i].getId());
                    System.out.print("        ");
                    System.out.print(productList[i].getName());
                    System.out.print("        ");
                    System.out.print(productList[i].getPrice());
                    System.out.print("        ");
                    System.out.println(((Books) productList[i]).getWriter());
                }
            }
        }
        System.out.println("-------------------------도서 목록 끝--------------------------");
        System.out.println();
    }


    public static void foodList() {
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■식품목록■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println("1: 상품id | 2: 상품명 | 3: 가격 |   4: 제조일     |   5: 유통기한     ");
        System.out.println("==================================================================");
        for (int i = 0; i < productList.length - 1; i++) {
            if (productList[i] != null && productList[i] instanceof Food) {
                if (productList[i].getType() == Product.foodType) {
                    System.out.print(productList[i].getId());
                    System.out.print("        ");
                    System.out.print(productList[i].getName());
                    System.out.print("        ");
                    System.out.print(productList[i].getPrice());
                    System.out.print("        ");
                    System.out.print(((Food) productList[i]).made);
                    System.out.print("        ");
                    System.out.println(((Food) productList[i]).limitation);
                }
            }
        }
        System.out.println("----------------------------식품 목록 끝----------------------------");
        System.out.println();
    }

    public static void electList() {
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■전자기기 목록■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println("1: 상품id | 2: 상품명 | 3: 가격 | 4: 제조사 | 5: 색상");
        System.out.println("===============================================================");
        for (int i = 0; i < productList.length - 1; i++) {
            if (productList[i] != null && productList[i] instanceof Elect) {
                if (productList[i].getType() == Product.electType) {
                    System.out.print(productList[i].getId());
                    System.out.print("        ");
                    System.out.print(productList[i].getName());
                    System.out.print("        ");
                    System.out.print(productList[i].getPrice());
                    System.out.print("        ");
                    System.out.print(((Elect) productList[i]).getCom());
                    System.out.print("        ");
                    System.out.println(((Elect) productList[i]).getCol());
                }
            }
        }
        System.out.println("-------------------------전자기기 목록 끝-------------------------");
        System.out.println();
    }



    private static Discount[] planedList(){
        Discount[] discount = new Discount[100];
        int index = 0;
        for (int i = 0; i < discount.length - 1; i++) {
            if (productList[i] != null && productList[i] instanceof Discount) {
                System.out.print((index + 1) + "번째 상품: ");
                showProduct(productList[i]);
                discount[index++] = (Discount) productList[i];
            }
        }
        return discount;
    }


    private static void showProduct(Product product) {
        if (product instanceof Books) {
            System.out.print("{ 도서명: " + (product).getName());
            System.out.print(", 저자: " + ((Books) product).getWriter());
            System.out.print(", 가격: " + (( product).getPrice()));
            System.out.print(", isbn: " + ((Books) product).getIsbn());
            System.out.print(", 재고: " + ( product).getStock() + " }");
        } else if (product instanceof Food) {
            System.out.print("{ 식품명: " + ( product).getName());
            System.out.print(", 가격: " + ( product).getPrice());
            System.out.print(", 제조일: " + ((Food) product).getMade());
            System.out.print(", 유통기한: " + ((Food) product).getLimitation().plusDays(10));
            System.out.print(", 재고: " + ( product).getStock() + " }");
        } else if (product instanceof Elect) {
            System.out.print("{ 제품명: " + ( product).getName());
            System.out.print(", 가격: " + ( product).getPrice());
            System.out.print(", 제조사: " + ((Elect) product).getCom());
            System.out.print(", 색상: " + ((Elect) product).getCol());

        }
        System.out.println();
    }
    private static void applyDiscount(Discount product, int discountRate) {
        product.setPriceByDiscountRate(discountRate);

    }
}


















