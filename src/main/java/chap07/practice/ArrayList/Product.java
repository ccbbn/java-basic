package chap07.practice.ArrayList;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;

public abstract class Product implements Serializable, Comparable<Product> {



    int id;
    String name;
    int price;
    int stock;
    String type;

    LocalDate made;
    LocalDate expiration;

    final static String  bookType = "도서";
    final static String  foodType = "식품";
    final static String  electType = "전자기기";


    public Product(){};

    public Product(int id, String name, int price, int stock, LocalDate made, LocalDate expiration, String type)  {

            this.id = id;
            this.name = name;
            this.price = price;
            this.stock = stock;
            this.type = type;
            this.made = made;
            this.expiration = expiration;
    }





    public LocalDate getMade() {
        return made;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getType() {
        return type;
    }
    public void setType(String  type) {
        this.type = type;
    }


    @Override
    public int compareTo(Product o) {
        if (this.price > o.price ) return -1;
        else if (this.price == o.price) return 0;
        else
            return 1;
    }

}


