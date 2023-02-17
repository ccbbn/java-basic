package chap07.practice.ArrayList;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

class Elect extends Product {

     String com;
     String col;

    public Elect(int id, String name, int price, int stock, String com, String col, LocalDate made, LocalDate expiration, int type) {
        super(id, name, price, stock, made, expiration, type);
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
