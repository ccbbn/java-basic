package chap07.practice.TotalAPi;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Excute {

    private static Scanner scanner = new Scanner(System.in);

    private static Product[] productList = new Product[100];

    static DecimalFormat numComma = new DecimalFormat("#,###");



    public static void main(String[] args) throws Exception {

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
                findName();
            } else if (selectNo.equals("5")) {
                alllist();
            } else if (selectNo.equals("6")) {
                eachList();
            } else if (selectNo.equals("7")) {
                applyDiscount();
            } else if (selectNo.equals("8")) {
                disposeProducts(disposables());
            } else if (selectNo.equals("0")) {
                run = false;
            } else {
                System.out.println("존재하지 않는 카테고리 입니다. 다시 입력하세요");
            }
        }
        System.out.println("프로그램 종료");


    }


    private static void addInventory()  {
        int i = 0;
        productList[i++] = new Books(123123, "초밥왕", 8000, 10, "데라사와", 110100, Product.bookType);
        productList[i++] = new Books(223223, "정처기", 23000, 50, "윤영빈", 123692, Product.bookType);
        productList[i++] = new Books(533433, "구해줘", 18000, 100, "기욤뮈소", 545100, Product.bookType);
        productList[i++] = new Food(778978, "떡볶이", 3000, 100, LocalDate.now(), LocalDate.now().minusDays(30), Product.foodType);
        productList[i++] = new Food(123978, "라볶이", 4000, 100, LocalDate.now(), LocalDate.now().minusDays(100), Product.foodType);
        productList[i++] = new Food(123978, "소고기", 50000, 100, LocalDate.now(), LocalDate.now().plusDays(3), Product.foodType);
        productList[i++] = new Elect(878876, "스마트폰", 500000, 10, "삼성", "블랙", Product.electType);
        productList[i++] = new Elect(675665, "냉장고", 1800000, 5, "LG", "실버", Product.electType);
        productList[i] = new Elect(233277, "스피커", 200000, 5, "BOSE", "화이트", Product.electType);

    }

    public static void selectMenu()  {
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
        String name = (String) ReceptionList.checkInputReception("문자입력");

        System.out.print("가격: ");
        int price = (int) ReceptionList.checkInputReception("양의정수입력");

        System.out.print("재고: ");
        int stock = (int) ReceptionList.checkInputReception("양의정수입력");

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

    public static void insertFood()  {

        System.out.print("상품ID: ");
        int id = ThreadLocalRandom.current().nextInt(100000, 1000000);
        System.out.println(id);

        System.out.print("상품명: ");
        String name = (String) ReceptionList.checkInputReception("문자입력");

        System.out.print("가격: ");
        int price = (int) ReceptionList.checkInputReception("양의정수입력");

        System.out.print("재고: ");
        int stock = (int) ReceptionList.checkInputReception("양의정수입력");

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

    public static void insertElect()  {

        System.out.print("상품ID: ");
        int id = ThreadLocalRandom.current().nextInt(100000, 1000000);
        System.out.println(id);

        System.out.print("상품명: ");
        String name = (String) ReceptionList.checkInputReception("문자입력");

        System.out.print("가격: ");
        int price = (int) ReceptionList.checkInputReception("양의정수입력");

        System.out.print("재고: ");
        int stock = (int) ReceptionList.checkInputReception("양의정수입력");

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

        String originName = (String) ReceptionList.checkInputReception("문자입력");
        if (!originName.equals("*")) {
            findName();

            System.out.print("바꿀이름은?? : ");

            String newName = (String) ReceptionList.checkInputReception("문자입력");

            if (!newName.equals("*")) {
                changeName(originName, newName);
                System.out.println(originName + "의 이름이 " + newName + "으로 변경되었습니다.");
            }
        }
    }

    public static void deleteProduct() {
        System.out.println("지울 상품 이름을 적으세요 | *: 카테고리 재선택");
        System.out.print("지울 상품 이름은?? : ");
        String productName = (String) ReceptionList.checkInputReception("문자입력");
        for (int i = 0; i < productList.length - 1; i++) {
            if (productList[i] != null) {
                if (productList[i].getName().equals(productName)) {
                    productList[i] = null;
                }
            }
        }
    }

    public static void findName() {

        System.out.println("찾는 상품이름을 적으세요");
        System.out.print("찾는 것은?? : ");
        String productName = (String) ReceptionList.checkInputReception("문자입력");

        for (int i = 0; i < productList.length - 1; i++) {
            if (productList[i] != null && productList[i] instanceof Books) {
                if (productList[i].getName().contains(productName)) {
                    System.out.println("================이름이 " + productName + " 인 도서 정보==============");
                    commonInfo(i);
                    System.out.println("작가 : " + ((Books) productList[i]).getWriter());
                }
            }

            else if (productList[i] != null && productList[i] instanceof Food) {
                if (productList[i].getName().contains(productName)) {
                    System.out.println("================이름이 " + productName + " 인 음식 정보==============");
                    commonInfo(i);
                    System.out.println("유통기한 : " + ((Food) productList[i]).getLimitation());
                }
            }

            else if (productList[i] != null && productList[i] instanceof Elect) {
                if (productList[i].getName().contains(productName)) {
                    System.out.println("==============이름이 " + productName + " 인 전자기기 정보============");
                    commonInfo(i);
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
                    commonInfo(i);
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
                    commonInfo(i);
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
                    commonInfo(i);
                    System.out.print(((Elect) productList[i]).getCom());
                    System.out.print("        ");
                    System.out.println(((Elect) productList[i]).getCol());
                }
            }
        }
        System.out.println("-------------------------전자기기 목록 끝-------------------------");
        System.out.println();
    }

    private static Disposable[] disposables() {
        Disposable[] disposables = new Disposable[100];
        int index = 0;
        for (int i = 0; i < disposables.length - 1; i++){
            if(productList[i] != null && (productList[i] instanceof Disposable)) {
                disposables[index++] = (Disposable) productList[i];
            }
        }
        return disposables;
    }



// 인터페이스 타입 배열을 반환하는 매서드 생성
    private static Discount[] interfaceArray() {
        Discount[] discount = new Discount[100];
        int index = 0;
        for (int i = 0; i < discount.length - 1; i++) {
            if (productList[i] != null && (productList[i] instanceof Discount)) {
                System.out.print((index + 1) + "번째 상품: ");
                showProductList(productList[i]);
                discount[index++] = (Discount) productList[i];
            }
        }
        return discount;
    }

    private static void showProductList(Product productList) {
        if (productList instanceof Books) {
            System.out.print("{ 도서명: " + productList.getName());
            System.out.print(", 저자: " + ((Books) productList).getWriter());
            System.out.print(", 가격: " + productList.getPrice());
            System.out.print(", isbn: " + ((Books) productList).getIsbn());
            System.out.print(", 재고: " + productList.getStock() + " }");
        } else if (productList instanceof Food) {
            System.out.print("{ 식품명: " + productList.getName());
            System.out.print(", 가격: " + productList.getPrice());
            System.out.print(", 제조일: " + ((Food) productList).getMade());
            System.out.print(", 유통기한: " + ((Food) productList).getLimitation().plusDays(10));
            System.out.print(", 재고: " + productList.getStock() + " }");
        } else if (productList instanceof Elect) {
            System.out.print("{ 제품명: " + productList.getName());
            System.out.print(", 가격: " + productList.getPrice());
            System.out.print(", 제조사: " + ((Elect) productList).getCom());
            System.out.print(", 색상: " + ((Elect) productList).getCol());

        }
        System.out.println();
    }

    private static void applyDiscount() {
        Discount[] interfacedProductList = interfaceArray(); // 생성된 인터페이스타입 배열 대입
        System.out.print("할인 적용할 상품을 선택해주세요: ");
        Discount targetProduct = interfacedProductList[scanner.nextInt() - 1]; // 인터페이스 실체 생성
        System.out.print("적용할 할인율을 입력하세요(10~90): ");
        int discountRate = (int) ReceptionList.checkInputReception("숫자입력");
        targetProduct.setPriceByDiscountRate(discountRate);

        //interfacedProductList[0].setPriceByDiscountRate(discountRate);
    }


    private static void commonInfo(int i){
        System.out.print(productList[i].getId());
        System.out.print("        ");
        System.out.print(productList[i].getName().replaceAll("\\s", ""));
        System.out.print("        ");
        System.out.print(numComma.format(productList[i].getPrice()));
        System.out.print("        ");
    }

    private static void disposeProducts(Disposable[] disposablesList) {
        int count = 0;
        disposablesList = disposables();
        for (int i = 0; i < disposablesList.length; i++) {
            if (disposablesList[i] != null) {






        }System.out.println(count + "개");
    }




}


















