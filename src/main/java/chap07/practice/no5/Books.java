package chap07.practice.no5;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Books extends Product {
    public static Books[] booksArray = new Books[100];
    static Scanner scanner = new Scanner(System.in);

    String writer;
    int isbn;
    int bookType;



    public Books(int id, String name, int price, int stock, String writer, int isbn, int bookType) {
        super(id, name, price, stock);

        this.writer = writer;
        this.isbn = isbn;
        this.bookType = bookType;
    }


    public static void addBook() {
        int i = 0;
        booksArray[i++] = new Books(123123,"초밥왕",8000,10,"데라사와",110100,1);
        booksArray[i++] = new Books(223223,"정처기",23000,50,"윤영빈",123692,1);
        booksArray[i++] = new Books(533433,"구해줘",18000,100,"기욤뮈소",545100,1);

    }



    // 책 입력 1
    public static void inputBook() {

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
        for (int i = 0; i <= booksArray.length; i++) {
            if (booksArray[i] == null) {
                booksArray[i] = books;
                break;
            }
        }
    }

    // 책 바꿈 2
    public static void changeBook(String bookName, String change) {
        for (int i = 0; i < booksArray.length - 1; i++) {
            if (booksArray[i] != null) {
                if (booksArray[i].getName().equals(bookName)) {
                    booksArray[i].setName(change);
                }
            }
        }
    }

    // 책 삭제 3
    public static void removeBook(String bookName) {
        for (int i = 0; i < booksArray.length - 1; i++) {
            if (booksArray[i] != null) {
                if (booksArray[i].getName().equals(bookName)) {
                    booksArray[i] = null;
                }
            }
        }
    }

    // 책 검색 4
    public static void findBookName(String bookName) {
        for (int i = 0; i < booksArray.length - 1; i++) {
            if (booksArray[i] != null) {
                if (booksArray[i].getName().equals(bookName)) {
                    System.out.println("================이름이 " + bookName + " 인 도서정보==============");
                    System.out.println("상품id : " + booksArray[i].getId());
                    System.out.println("책이름 : " + booksArray[i].getName());
                    System.out.println("가격 : " + booksArray[i].getPrice());
                    System.out.println("작가 : " + booksArray[i].getWriter());
                }
            }
        }
    }

    // 책 정보 6
    public static void bookList() {
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
                System.out.println(booksArray[i].getWriter());
            }
        }
        System.out.println("-------------------------도서 목록 끝--------------------------");
        System.out.println();

    }



    public String getWriter() { return writer; }
    public void setWriter(String writer) { this.writer = writer; }

    public int getIsbn() { return isbn; }
    public void setIsbn(int isbn) { this.isbn = isbn; }



}
