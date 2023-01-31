package chap07.practice.no2;

import java.awt.print.Book;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Books extends Product{
    public static Books[] booksArray = new Books[100];
    public static Scanner scanner = new Scanner(System.in);
    String writer;
    int isbn;


    public Books(int id, String name, int price, int stock, String writer, int isbn) {
        super(id, name, price, stock);
        this.writer = writer;
        this.isbn = isbn;
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

        Books books = new Books(id, name, price, stock, writer, isbn);
        for (int i = 0; i <= booksArray.length; i++) {
            if (booksArray[i] == null) {
                booksArray[i] = books;
                break;
            }
        }
    }

    // 책 검색 4
    public static void findBookName(String pName) {
        int i = 0;
        System.out.println(pName + " 의 이름을 갖는 도서정보");
        while (booksArray[i] != null) {
            if (booksArray[i].getName().equals(pName)) {
                System.out.println("===============");
                System.out.println("상품id : " + booksArray[i].getId());
                System.out.println("가격 : " + booksArray[i].getPrice());
                System.out.println("작가 : " + booksArray[i].getWriter());
                System.out.println();
            }
            i++;
        }
    }

    // 책 정보 6
    public static void bookList() {
        if (Books.booksArray[0] != null) {
            System.out.println("1: 상품id | 2: 상품명 | 3: 저자");
            System.out.println("=============================================================");
        } else {
            System.out.println("책은 없음");
        }
        int i = 0;
        while (Books.booksArray[i] != null) {
            System.out.print(Books.booksArray[i].getId());
            System.out.print("        ");
            System.out.print(Books.booksArray[i].getName());
            System.out.print("        ");
            System.out.println(Books.booksArray[i].getWriter());
            i++;
        }
    }



    public String getWriter() { return writer; }
    public void setWriter(String writer) { this.writer = writer; }

    public int getIsbn() { return isbn; }
    public void setIsbn(int isbn) { this.isbn = isbn; }



}
