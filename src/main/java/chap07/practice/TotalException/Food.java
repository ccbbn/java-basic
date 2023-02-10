package chap07.practice.TotalException;

import java.time.LocalDate;
import java.util.Scanner;

public class Food extends Product implements Discount {
    public static Food[] foodArray = new Food[100];
    static Scanner scanner = new Scanner(System.in);

    LocalDate made;
    LocalDate limitation;

    public Food(){};

    public Food(int id, String name, int price, int stock, LocalDate made, LocalDate limitation,int type) throws RangeInvalidException {
        super(id, name, price, stock, type);



        this.made = made;
        this.limitation = limitation;
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

    public LocalDate getLimitation() {
        return limitation;
    }

    public void setLimitation(LocalDate limitation) {
        this.limitation = limitation;
    }

    @Override
    public void setPriceByDiscountRate(int rate) {
        while (rate < 10 || rate > 90) {
            System.out.println("10 ~ 90 까지 값만 입력해주세요");
            rate = new Scanner(System.in).nextInt();
        }

        double ratedPrice = this.getPrice() -  (((double)rate / 100) * this.getPrice());
        this.setPrice((int)(ratedPrice));
    }

}


