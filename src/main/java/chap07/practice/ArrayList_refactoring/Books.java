package chap07.practice.ArrayList_refactoring;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Books extends Product {

    DecimalFormat comma = new DecimalFormat("#,###");

    String writer;
    int isbn;


    public Books(int id, String name, int price, int stock, String writer, int isbn, LocalDate made, LocalDate expiration, int type)  {
        super(id, name, price, stock, made, expiration, type);
        this.writer = writer;
        this.isbn = isbn;

    }

    public String getWriter() { return writer; }
    public void setWriter(String writer) { this.writer = writer; }

    public int getIsbn() { return isbn; }
    public void setIsbn(int isbn) { this.isbn = isbn; }



}
