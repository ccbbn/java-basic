package chap07.practice.no4;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Books implements Order{

    public static Books[] booksArray= new Books[50];
    Scanner scanner = new Scanner(System.in);

    int id;
    String name;
    int price;
    int stock;
    String writter;
    int isbn;
    int bookType;

    public Books(){}

    public Books(int id, String name, int price, int stock, String writter, int isbn, int bookType ){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.writter = writter;
        this.isbn = isbn;
        this.bookType = bookType;

    }

    @Override
    public void add() {
        int i = 0;
        booksArray[i++] = new Books(123123,"초밥왕",8000,10,"데라사와",110100,1);
        booksArray[i++] = new Books(223223,"정처기",23000,50,"윤영빈",123692,1);
        booksArray[i++] = new Books(533433,"구해줘",18000,100,"기욤뮈소",545100,1);

    }


    @Override
    public void insert() {

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

            Books books = new Books(id, name, price, stock, writer, isbn, Order.bookType);
            for (int i = 0; i <= booksArray.length; i++) {
                if (booksArray[i] == null) {
                    booksArray[i] = books;
                    break;
                }
            }
        }


    @Override
    public void change(String findName, String change) {
        for (int i = 0; i < booksArray.length - 1; i++) {
            if (booksArray[i] != null) {
                if (booksArray[i].getName().equals(findName)) {
                    booksArray[i].setName(change);
                }
            }
        }
    }


    @Override
    public void delete(String deleteName) {
        for (int i = 0; i < booksArray.length - 1; i++) {
            if (booksArray[i] != null) {
                if (booksArray[i].getName().equals(deleteName)) {
                    booksArray[i] = null; //return;
                }
            }
        }
        //System.out.println("없어");
    }


    @Override
    public void find(String findName) {
        for (int i = 0; i < booksArray.length - 1; i++) {
            if (booksArray[i] != null) {
                if (booksArray[i].getName().equals(findName)) {
                    System.out.println("================이름이 " + findName + " 인 도서정보==============");
                    System.out.println("상품id : " + booksArray[i].getId());
                    System.out.println("책이름: " + booksArray[i].getName());
                    System.out.println("가격 : " + booksArray[i].getPrice());
                    System.out.println("작가 : " + booksArray[i].getWritter());
                }
            }
        }
    }


    @Override
    public void allList() {
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■도서목록■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println("1: 상품id | 2: 상품명 | 3: 가격 | 4: 저자");
        System.out.println("=============================================================");
        for (int i = 0; i < booksArray.length - 1; i++) {
            if (booksArray[i] != null) {
                System.out.print(booksArray[i].getId());
                System.out.print("        ");
                System.out.print(booksArray[i].getName());
                System.out.print("        ");
                System.out.print(booksArray[i].getPrice());
                System.out.print("        ");
                System.out.println(booksArray[i].getWritter());
            }
        }
        System.out.println("-------------------------도서 목록 끝--------------------------");
        System.out.println();
    }


    @Override
    public void discount(String findName, int rate) {
        for (int i = 0; i < booksArray.length - 1; i++) {
            if (booksArray[i] != null) {
                if (booksArray[i].getName().equals(findName)) {
                    booksArray[i].setPrice(booksArray[i].getPrice() - (int)( 0.01 * rate * booksArray[i].getPrice()));
                }
            }
        }
    }









    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getWritter() {
        return writter;
    }

    public void setWritter(String writter) {
        this.writter = writter;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getBookType() {
        return bookType;
    }

    public void setBookType(int bookType) {
        this.bookType = bookType;
    }
}
