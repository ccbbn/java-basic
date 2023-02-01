package chap07.practice.no2;

import chap07.poly.ex1.E;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

 class Elect extends Product {


     static Elect[] electsArray = new Elect[20];
     static Scanner scanner = new Scanner(System.in);


    String com;
    String col;

    public Elect(int id, String name, int price, int stock, String com, String col) {
        super(id, name, price, stock);
        this.com = com;
        this.col = col;
    }

    // 전자기기 입력 1
    public static void inputElect() {

        System.out.print("상품ID: ");
        int id = ThreadLocalRandom.current().nextInt(100000, 1000000);
        System.out.println(id);

        System.out.print("상품명: ");
        String name = scanner.next();

        System.out.print("가격: ");
        int price = scanner.nextInt();

        System.out.print("재고: ");
        int stock = scanner.nextInt();

        System.out.print("제조사: ");
        String com = scanner.next();

        System.out.print("색: ");
        String col = scanner.next();

        System.out.println("-----입력완료-----");

        Elect elect = new Elect(id, name, price, stock, com, col);
        for (int i = 0; i <= electsArray.length; i++) {
            if (electsArray[i] == null) {
                electsArray[i] = elect;
                break;
            }
        }

    }

     // 전자기기 검색 4
     public static void findElectName(String pName) {
         int i = 0;
         System.out.println(pName + " 의 이름을 갖는 전자기기 정보");
         while (electsArray[i] != null) {
             if (electsArray[i].getName().equals(pName)) {
                 System.out.println("==============");
                 System.out.println("상품id : " + electsArray[i].getId());
                 System.out.println("제조회사 : " + electsArray[i].getCom());
                 System.out.println("색상 : " + electsArray[i].getCol());
                 System.out.println();
             }
             i++;
         }
     }

     // 전자기기 목록 6
     public static void electList() {
         int k = 0;
         while (Elect.electsArray[k] != null) {
             System.out.print(Elect.electsArray[k].getId());
             System.out.print("        ");
             System.out.print(Elect.electsArray[k].getName());
             System.out.print("        ");
             System.out.print(Elect.electsArray[k].getCom());
             System.out.print("        ");
             System.out.println(Elect.electsArray[k].getCol());
             k++;
         }
     }

     @Override
     public void reWrite() {

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
