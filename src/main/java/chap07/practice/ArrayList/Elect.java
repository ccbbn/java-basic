package chap07.practice.ArrayList;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

class Elect extends Product {

     String com;
     String col;

    public Elect(int id, String name, int price, int stock, String com, String col, LocalDate made, LocalDate expiration, String type) {
        super(id, name, price, stock, made, expiration, type);
        this.com = com;
        this.col = col;
    }


     public String getType() {
         return type;
     }

     public void setType(String type) {
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
