package chap08.inter_ex;

import chap07.poly.ex1.C;

public class Execute {
    public static void main(String[] args) {
        Son jg = new Son();

        Cookable chef = new Chef();
        Cookable mother = new Mother();
        Cookable motherInLow = new MotherInLow();

        jg.requestFood(chef);
        jg.requestFood(mother);
        jg.requestFood(motherInLow);



    }
}
