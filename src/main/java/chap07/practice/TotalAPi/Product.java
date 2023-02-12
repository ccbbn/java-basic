package chap07.practice.TotalAPi;

import java.time.LocalDate;

public abstract class Product {


    int id;
    String name;
    int price;
    int stock;
    int type;

    LocalDate made;
    LocalDate expiration;

    final static int bookType = 1;
    final static int foodType = 2;
    final static int electType = 3;


    public Product(){};

    public Product(int id, String name, int price, int stock, LocalDate made, LocalDate expiration, int type)  {

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

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }


}


