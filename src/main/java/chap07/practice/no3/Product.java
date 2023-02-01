package chap07.practice.no3;

public abstract class Product {

    int id;
    String name;
    int price;
    int stock;

    static final int seed1 = 1;
    static final int seed2 = 2;

    static final int seed3 = 3;

    Product() {

    }

    public Product(int id, String name, int price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }


    abstract public void reWrite();





    //public abstract void findName(String pName);





    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

}


