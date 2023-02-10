package chap07.practice.Total;

public abstract class Product {


    int id;
    String name;
    int price;
    int stock;
    int type;

    final static int bookType = 1;
    final static int foodType = 2;
    final static int electType = 3;


    public Product(){};

    public Product(int id, String name, int price, int stock, int type)throws RangeInvalidException {


        if ( price < 0 || stock < 0) {
            throw new RangeInvalidException("음수 불가");
        }
            this.id = id;
            this.name = name;
            this.price = price;
            this.stock = stock;
            this.type = type;
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


