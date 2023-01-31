package chap07.practice.no2;

import java.time.LocalDate;

public class Food extends Product {
    LocalDate made;
    LocalDate limitation;

    public Food(int id, String name, int price, int stock, LocalDate made, LocalDate limitation) {
        super(id, name, price, stock);
    }
}
