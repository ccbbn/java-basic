package chap07.practice.Total;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

 class Elect extends Product {

     public static Elect[] electsArray = new Elect[20];
     static Scanner scanner = new Scanner(System.in);

     String com;
     String col;

    public Elect(int id, String name, int price, int stock, String com, String col, int type) throws RangeInvalidException {
        super(id, name, price, stock, type);
        this.com = com;
        this.col = col;
    }


     public int getType() {
         return type;
     }

     public void setType(int type) {
         this.type = type;
     }

     public String getCom() {
         return com;
     }

     public void setCom(String com) {
         this.com = com;
     }

     public String getCol() {
         return col;
     }

     public void setCol(String col) {
         this.col = col;
     }
 }
