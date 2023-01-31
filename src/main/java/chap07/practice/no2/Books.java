package chap07.practice.no2;

public class Books extends Product{
    String writer;
    int isbn;

    public Books(int id, String name, int price, int stock, String writer, int isbn) {
        super(id, name, price, stock);
    }

    public String getWriter() { return writer; }
    public void setWriter(String writer) { this.writer = writer; }

    public int getIsbn() { return isbn; }
    public void setIsbn(int isbn) { this.isbn = isbn; }



}
