package chap07.practice.TotalAPi;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;


public class Food extends Product implements Discount, Disposable {
    public static Food[] foodArray = new Food[100];
    static Scanner scanner = new Scanner(System.in);



    LocalDate made;
    LocalDate expiration;



    public Food() {
    }


    public Food(int id, String name, int price, int stock, LocalDate made, LocalDate expiration, int type) {
        super(id, name, price, stock, made, expiration, type);
        this.made = made;
        this.expiration = expiration;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public LocalDate getMade() {
        return made;
    }

    public void setMade(LocalDate made) {
        this.made = made;
    }

    public LocalDate getExpiration() {
        return expiration;
    }




    public void setLimitation(LocalDate expiration) {
        this.expiration = expiration;
    }


    @Override
    public void setPriceByDiscountRate(int rate) {
        while (rate < 10 || rate > 90) {
            System.out.println("10 ~ 90 까지 값만 입력해주세요");
            rate = new Scanner(System.in).nextInt();
        }

        double ratedPrice = this.getPrice() - (((double) rate / 100) * this.getPrice());
        this.setPrice((int) (ratedPrice));
    }

    @Override
    public boolean isExpiredDate() {
        boolean isExpiredDate = false;
        if( LocalDate.now().isAfter(this.getExpiration())){
            isExpiredDate = true;
        }
        return isExpiredDate;
    }

}



