package chap18.ex05;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {
	private static final long serialVersionUID = -621812868470078544L;
	private String name;
	private int price;

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
//	@Override
//	public String toString() { return name + ": " + price; }
}