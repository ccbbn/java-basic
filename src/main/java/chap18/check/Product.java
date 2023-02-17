package chap18.check;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable{

    public static Object builder;
    String name;
    int price;
    int stock;

    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }


}


