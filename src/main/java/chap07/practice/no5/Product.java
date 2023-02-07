package chap07.practice.no5;

public abstract class Product {

    int id;
    String name;
    int price;
    int stock;

    final static int bookType = 1;
    final static int foodType = 2;
    final static int electType = 3;


    public Product(){};

    public Product(int id, String name, int price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }



    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

}


