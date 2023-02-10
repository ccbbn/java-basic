package chap07.practice.Total;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Books extends Product {
    public static Books[] booksArray = new Books[100];
    static Scanner scanner = new Scanner(System.in);

    String writer;
    int isbn;


    public Books(int id, String name, int price, int stock, String writer, int isbn, int type) throws RangeInvalidException {
        super(id, name, price, stock, type);
        this.writer = writer;
        this.isbn = isbn;

    }

    public String getWriter() { return writer; }
    public void setWriter(String writer) { this.writer = writer; }

    public int getIsbn() { return isbn; }
    public void setIsbn(int isbn) { this.isbn = isbn; }



}
