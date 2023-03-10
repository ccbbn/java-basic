package chap07.practice.no2;

import chap07.poly.ex1.E;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

 class Elect extends Product {

     public static Elect[] electsArray = new Elect[20];
     static Scanner scanner = new Scanner(System.in);

     String com;
     String col;
     int electType;

    public Elect(int id, String name, int price, int stock, String com, String col, int electType) {
        super(id, name, price, stock);
        this.com = com;
        this.col = col;
        this.electType = electType;
    }

    static void addElect(){
        int i = 0;
        electsArray[i++] = new Elect(878876,"스마트폰",500000,10,"삼성","블랙",3);
        electsArray[i++] = new Elect(675665,"냉장고",1800000,5,"LG","실버",3);
        electsArray[i++] = new Elect(233277,"스피커",200000,5,"BOSE","화이트",3);

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

        Elect elect = new Elect(id, name, price, stock, com, col,Product.electType);
        for (int i = 0; i <= electsArray.length; i++) {
            if (electsArray[i] == null) {
                electsArray[i] = elect;
                break;
            }
        }
    }

     // 전자기기 바꿈 2
     public static void changeElect(String electName, String change) {
         for (int i = 0; i < electsArray.length - 1; i++) {
             if (electsArray[i] != null) {
                 if (electsArray[i].getName().equals(electName)) {
                     electsArray[i].setName(change);
                 }
             }
         }
     }

     // 전자기기 삭제 3
     public static void removeElect(String electName) {
         for (int i = 0; i < electsArray.length - 1; i++) {
             if (electsArray[i] != null) {
                 if (electsArray[i].getName().equals(electName)) {
                     electsArray[i] = null;
                 }
             }
         }
     }

     // 전자기기 검색 4
     public static void findElectName(String electName) {
         for (int i = 0; i < electsArray.length - 1; i++) {
             if (electsArray[i] != null) {
                if (electsArray[i].getName().equals(electName)) {
                    System.out.println("==============이름이 " + electName + " 인 전자기기 정보============");
                    System.out.println("상품id : " + electsArray[i].getId());
                    System.out.println("전자기기 이름: " + electsArray[i].getName());
                    System.out.println("전자기기 가격: " + electsArray[i].getPrice());
                    System.out.println("제조회사 : " + electsArray[i].getCom());
                    System.out.println("색상 : " + electsArray[i].getCol());
                }
             }
         }
     }

     // 전자기기 목록 6
     public static void electList() {
         System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■전자기기 목록■■■■■■■■■■■■■■■■■■■■■■■■■■■");
         System.out.println("1: 상품id | 2: 상품명 | 3: 가격 | 4: 제조사 | 5: 색상");
         System.out.println("===============================================================");
         for (int i = 0; i < electsArray.length - 1; i++) {
             if (electsArray[i] != null) {
                 System.out.print(Elect.electsArray[i].getId());
                 System.out.print("        ");
                 System.out.print(Elect.electsArray[i].getName());
                 System.out.print("        ");
                 System.out.print(Elect.electsArray[i].getPrice());
                 System.out.print("        ");
                 System.out.print(Elect.electsArray[i].getCom());
                 System.out.print("        ");
                 System.out.println(Elect.electsArray[i].getCol());
             }
         }
         System.out.println("-------------------------전자기기 목록 끝-------------------------");
         System.out.println();

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
