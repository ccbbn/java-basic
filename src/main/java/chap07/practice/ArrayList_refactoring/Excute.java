package chap07.practice.ArrayList_refactoring;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


public class Excute {

    private static Scanner scanner = new Scanner(System.in);

    private static ArrayList<Product> productList = new ArrayList<>();

    static DecimalFormat numComma = new DecimalFormat("#,###");


    public static void main(String[] args) throws Exception {

//        productList.add(new Books(1,"1",1,1,"1",1,LocalDate.now(),LocalDate.now(),1));

        addInventory();
        loadInventory();

        boolean run = true;
        while (run) {
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            System.out.println("1.상품추가 | 2.정보수정 | 3.삭제 | 4.상품명 조회 | 5.모든 상품 조회 | 6.상품 카테고리별 조회 | 7. 할인율 적용 | 8. 상품 폐기 | 0.종료");
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            System.out.print("선택> ");

            String selectNo = scanner.next();

            if (selectNo.equals("1")) {
                insertProduct();
            } else if (selectNo.equals("2")) {
                updateProduct();
            } else if (selectNo.equals("3")) {
                deleteInputtedProduct();
            } else if (selectNo.equals("4")) {
                findName();
            } else if (selectNo.equals("5")) {
                alllist();
            } else if (selectNo.equals("6")) {
                eachList();
            } else if (selectNo.equals("7")) {
                applyDiscount();
            } else if (selectNo.equals("8")) {
                disposeProducts();
            } else if (selectNo.equals("9")) {
                decending();
            } else if (selectNo.equals("0")) {
                run = false;
            } else {
                System.out.println("존재하지 않는 카테고리 입니다. 다시 입력하세요");
            }
        }
        System.out.println("프로그램 종료");


    }


    private static void addInventory() throws Exception {

        FileOutputStream fos = new FileOutputStream("C:/Temp/ListedProductFile.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        int i = 0;
        Product[] product = new Product[14];

        product[i++] = (new Books(123123, "초밥왕", 8000, 10, "데라사와", 110100, LocalDate.now(), LocalDate.now().plusYears(100), Product.bookType));
        product[i++] = (new Books(223223, "정처기", 23000, 50, "윤영빈", 123692, LocalDate.now(), LocalDate.now().plusYears(100), Product.bookType));
        product[i++] = (new Books(533433, "구해줘", 18000, 100, "기욤뮈소", 545100, LocalDate.now(), LocalDate.now().plusYears(100), Product.bookType));
        product[i++] = (new Books(423664, "해리포터와 불의잔", 18000, 200, "jk롤링", 545100, LocalDate.now(), LocalDate.now().plusYears(100), Product.bookType));
        product[i++] = (new Books(538563, "해리포터와 마법사의 돌", 18000, 150, "jk롤링", 545100, LocalDate.now(), LocalDate.now().plusYears(100), Product.bookType));
        product[i++] = (new Books(677111, "해리포터와 비밀의 방", 18000, 300, "jk롤링", 545100, LocalDate.now(), LocalDate.now().plusYears(100), Product.bookType));
        product[i++] = (new Books(789952, "실전투자의 비밀", 18000, 400, "김박사", 545100, LocalDate.now(), LocalDate.now().plusYears(100), Product.bookType));
        product[i++] = (new Books(583433, "오즈의 마법사", 12000, 500, "jk롤링", 545100, LocalDate.now(), LocalDate.now().plusYears(100), Product.bookType));
        product[i++] = (new Food(778978, "떡볶이", 3000, 100, LocalDate.now().minusDays(30), LocalDate.now().minusDays(15), Product.foodType));
        product[i++] = (new Food(123978, "라볶이", 4000, 100, LocalDate.now().minusDays(60), LocalDate.now().minusDays(30), Product.foodType));
        product[i++] = (new Food(123978, "소고기", 50000, 100, LocalDate.now().minusDays(1), LocalDate.now().plusDays(3), Product.foodType));
        product[i++] = (new Elect(878876, "스마트폰", 500000, 10, "삼성", "블랙", LocalDate.now(), LocalDate.now().plusYears(100), Product.electType));
        product[i++] = (new Elect(675665, "냉장고", 1800000, 5, "LG", "실버", LocalDate.now(), LocalDate.now().plusYears(100), Product.electType));
        product[i++] = (new Elect(233277, "스피커", 200000, 5, "BOSE", "화이트", LocalDate.now(), LocalDate.now().plusYears(100), Product.electType));

        oos.writeObject(product);

        oos.flush();
        oos.close();
        fos.close();

    }

    private static void loadInventory() throws Exception {
        FileInputStream fis = new FileInputStream("C:/Temp/ListedProductFile.dat");
        ObjectInputStream ois2 = new ObjectInputStream(fis);


        Product[] product = (Product[]) ois2.readObject();
        for (int i = 0; i < product.length; i++) {
            productList.add(product[i]);
        }
        ois2.close();
        fis.close();

    }

    public static void insertProduct() {
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


        LocalDate made = LocalDate.now();
        LocalDate expiration = LocalDate.now().plusYears((long) (Math.random() * 100));

        System.out.println("-----입력완료-----");

        Books books = new Books(id, name, price, stock, writer, isbn, made, expiration, Product.bookType);
        productList.add(books);
    }


    public static void insertFood() {

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
        LocalDate made = LocalDate.now().minusDays((long) (Math.random() * 100));
        System.out.println(made);

        System.out.print("유통기한: ");
        LocalDate expiration = LocalDate.now().plusDays((long) (Math.random() * 100));
        System.out.println(expiration);

        System.out.println("-----입력완료-----");


        Food food = new Food(id, name, price, stock, made, expiration, Product.foodType);
        productList.add(food);
    }

    public static void insertElect() {

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

        LocalDate made = LocalDate.now();
        LocalDate expiration = LocalDate.now().plusYears((long) (Math.random() * 100));

        System.out.println("-----입력완료-----");

        Elect elect = new Elect(id, name, price, stock, com, col, made, expiration, Product.electType);
        productList.add(elect);
    }

    public static void changeName(String originName, String newName) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(originName)) {
                productList.get(i).setName(newName);
                return;
            }
        }
    }

    public static void updateProduct() {
        System.out.println("찾는 상품이름을 적으세요 | *: 처음으로 돌아가기");
        System.out.print("찾는 것은?? : ");

        String originName = (String) ReceptionList.checkInputReception("문자입력");
        if (!originName.equals("*")) {
            filteredList(originName);

            System.out.print("바꿀이름은?? : ");

            String newName = (String) ReceptionList.checkInputReception("문자입력");

            if (!newName.equals("*")) {
                changeName(originName, newName);
                System.out.println(originName + "의 이름이 " + newName + "으로 변경되었습니다.");
            }
        }
    }

    public static void deleteInputtedProduct() {
        System.out.println("지울 상품 이름을 적으세요 | *: 카테고리 재선택");
        System.out.print("지울 상품 이름은?? : ");
        String productName = (String) ReceptionList.checkInputReception("문자입력");
        deleteProduct(productName);
    }

    public static void deleteProduct(String productName) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(productName)) {
                productList.remove(i);
                return;
            }
        }
    }


    public static void findName() {

        System.out.println("찾는 상품이름을 적으세요");
        System.out.print("찾는 것은?? : ");
        String productName = (String) ReceptionList.checkInputReception("문자입력");
        filteredList(productName);


    }

    private static void alllist() {
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
        System.out.println("1: 상품id | 2: 상품명 | 3: 가격 | 4: 재고 | 5: 저자");
        System.out.println("=============================================================");
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) instanceof Books) {
                if (productList.get(i).getType() == Product.bookType) {
                    commonInfo(i);
                    System.out.println(((Books) productList.get(i)).getWriter());
                }
            }
        }
        System.out.println("-------------------------도서 목록 끝--------------------------");
        System.out.println();
    }

    public static void foodList() {
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■식품목록■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println("1: 상품id | 2: 상품명 | 3: 가격 | 4: 재고  |  5: 제조일  | 6: 유통기한  ");
        System.out.println("==================================================================");
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) instanceof Food) {
                if (productList.get(i).getType() == Product.foodType) {
                    commonInfo(i);
                    System.out.print(((Food) productList.get(i)).made);
                    System.out.print("    ");
                    System.out.println(((Food) productList.get(i)).expiration);
                }
            }
        }
        System.out.println("----------------------------식품 목록 끝---------------------------");
        System.out.println();
    }

    public static void electList() {
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■전자기기 목록■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println("1: 상품id | 2: 상품명 | 3: 가격 | 4: 재고 | 5: 제조사  | 6: 색상 ");
        System.out.println("===============================================================");
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) instanceof Elect) {
                if (productList.get(i).getType() == Product.electType) {
                    commonInfo(i);
                    System.out.print(((Elect) productList.get(i)).getCom());
                    System.out.print("    ");
                    System.out.println(((Elect) productList.get(i)).getCol());
                }
            }
        }
        System.out.println("-------------------------전자기기 목록 끝-------------------------");
        System.out.println();
    }


    // 인터페이스 타입 배열을 반환하는 매서드 생성
    private static ArrayList<Discount> interfaceArray() {
        int index = 0;
//        ArrayList<Discount> discount = new ArrayList<>((Collection) productList);
//        showProductList((Product) discount.get(i));

        ArrayList<Discount> discount = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) instanceof Discount) {
                discount.add((Discount) productList.get(i));
                System.out.print((index++ + 1) + "번째 상품: ");
                showProductList(productList.get(i));
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
            System.out.print(", 유통기한: " + ((Food) productList).getExpiration().plusDays(10));
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
        ArrayList<Discount> interfacedProductList = interfaceArray(); // 생성된 인터페이스타입 배열 대입
        System.out.print("할인 적용할 상품을 선택해주세요: ");
        Discount targetProduct = interfacedProductList.get(scanner.nextInt() - 1); // 인터페이스 실체 생성
        System.out.print("적용할 할인율을 입력하세요(10~90): ");
        int discountRate = (int) ReceptionList.checkInputReception("숫자입력");
        targetProduct.setPriceByDiscountRate(discountRate);

        //interfacedProductList[0].setPriceByDiscountRate(discountRate);
    }

    private static void filteredList(String productName) {

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) instanceof Books) {
                if (productList.get(i).getName().contains(productName)) {
                    System.out.println("================이름에 " + productName + " 가 포함된 도서 정보==============");
                    commonInfo(i);
                    System.out.println("작가 : " + ((Books) productList.get(i)).getWriter());
                }
            } else if (productList.get(i) instanceof Food) {
                if (productList.get(i).getName().contains(productName)) {
                    System.out.println("================이름이 " + productName + " 인 음식 정보==============");
                    commonInfo(i);
                    System.out.println("유통기한 : " + ((Food) productList.get(i)).getExpiration());
                }
            } else if (productList.get(i) instanceof Elect) {
                if (productList.get(i).getName().contains(productName)) {
                    System.out.println("==============이름이 " + productName + " 인 전자기기 정보============");
                    commonInfo(i);
                    System.out.println("제조회사 : " + ((Elect) productList.get(i)).getCom());
                    System.out.println("색상 : " + ((Elect) productList.get(i)).getCol());
                }
            }
        }
    }


    private static void commonInfo(int i) {
        System.out.print(productList.get(i).getId());
        System.out.print("    ");
        System.out.print(productList.get(i).getName());
        System.out.print("    ");
        System.out.print(numComma.format(productList.get(i).getPrice()));
        System.out.print("    ");
        System.out.print(numComma.format(productList.get(i).getStock()));
        System.out.print("    "); // 전역변수 최소화
    }

    private static ArrayList<Disposable> disposables() {
        ArrayList<Disposable> disposables = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) instanceof Disposable) {
                disposables.add((Disposable) productList.get(i));
            }
        }
        return disposables;
    }

    private static void disposeProducts() {
        int count = 0;
        ArrayList<Disposable> disposablesList = disposables();
        for (int i = 0; i < disposablesList.size(); i++) {
            if ((disposablesList.get(i).isExpiredDate())) {
                count++;
                System.out.println(((Product) disposablesList.get(i)).getName() + "의 재고 " + ((Product) disposablesList.get(i)).getStock() + "개가 폐기됨" +
                        "/ 유통기한 : " + ((Product) disposablesList.get(i)).getExpiration() + "/ 오늘 날짜로 부터 " +
                        ChronoUnit.DAYS.between(((Product) disposablesList.get(i)).getExpiration(), LocalDate.now()) + "일 지남");
                deleteProduct(((Product) disposablesList.get(i)).getName());

                // products[i] instanceof Disposalabe
            }
        }
        System.out.println("총 " + count + "가지의 품목이 폐기되었습니다.");
    }


    private static void decending() {


//        convertTOChildArray();


        System.out.println("낮은 상품부터 보여줍니다");
        productList.stream().sorted().forEach(product -> System.out.println(
                "가격 : " + product.getPrice() + " / " + " [ 상품명 : " + product.getName() + " ]" + " [ 재고 : " + product.getStock() + " ]"));




//        ArrayList<Books> booksList = productList.stream().filter(product -> product instanceof Books).map(product -> (Books)product).collect(Collectors.toCollection(ArrayList::new));
//        booksList.stream().sorted().forEach(book -> System.out.println(book.getWriter()));

        ArrayList<Books> booksList = productList.stream()
                .filter(product -> product instanceof Books)
                .map(product -> (Books) product)
                .collect(Collectors.toCollection(ArrayList::new));

        booksList.stream().sorted().forEach(book -> System.out.println(book.getWriter()));



    }

}























