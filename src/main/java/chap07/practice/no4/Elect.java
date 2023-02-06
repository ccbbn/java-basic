package chap07.practice.no4;

import chap07.poly.ex1.E;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Elect implements Order{
    public Elect[] electArray= new Elect[50];
    Scanner scanner = new Scanner(System.in);

    int id;
    String name;
    int price;
    int stock;
    String com;
    String col;

    int electType;

    public Elect() {}

    public Elect(int id, String name, int price, int stock, String com, String col, int electType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.com = com;
        this.col = col;
        this.electType = electType;
    }


    @Override
    public void add() {
        int i = 0;
        electArray[i++] = new Elect(878876,"스마트폰",500000,10,"삼성","블랙",3);
        electArray[i++] = new Elect(675665,"냉장고",1800000,5,"LG","실버",3);
        electArray[i++] = new Elect(233277,"스피커",200000,5,"BOSE","화이트",3);
    }

    @Override
    public void insert() {

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

        Elect elect = new Elect(id, name, price, stock, com, col, Order.electType);
        for (int i = 0; i <= electArray.length; i++) {
            if (electArray[i] == null) {
                electArray[i] = elect;
                break;
            }
        }

    }

    @Override
    public void change(String findName, String change) {
        for (int i = 0; i < electArray.length - 1; i++) {
            if (electArray[i] != null) {
                if (electArray[i].getName().equals(findName)) {
                    electArray[i].setName(change);
                }
            }
        }
    }


    @Override
    public void delete(String deleteName) {
        for (int i = 0; i < electArray.length - 1; i++) {
            if (electArray[i] != null) {
                if (electArray[i].getName().equals(deleteName)) {
                    electArray[i] = null;
                }
            }
        }
    }


    @Override
    public void find(String findName) {
        for (int i = 0; i < electArray.length - 1; i++) {
            if (electArray[i] != null) {
                if (electArray[i].getName().equals(findName)) {
                    System.out.println("==============이름이 " + findName + " 인 전자기기 정보============");
                    System.out.println("상품id : " + electArray[i].getId());
                    System.out.println("전자기기 이름: " + electArray[i].getName());
                    System.out.println("제조회사 : " + electArray[i].getCom());
                    System.out.println("색상 : " + electArray[i].getCol());
                }
            }
        }
    }



    @Override
    public void allList() {
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■전자기기 목록■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println("1: 상품id | 2: 상품명 | 3: 가격 | 4: 제조사 | 5: 색상");
        System.out.println("=============================================================");
        for (int i = 0; i < electArray.length - 1; i++) {
            if (electArray[i] != null) {
                System.out.print(electArray[i].getId());
                System.out.print("        ");
                System.out.print(electArray[i].getName());
                System.out.print("        ");
                System.out.print(electArray[i].getPrice());
                System.out.print("        ");
                System.out.print(electArray[i].getCom());
                System.out.print("        ");
                System.out.println(electArray[i].getCol());
            }
        }
        System.out.println("-------------------------전자기기 목록 끝-------------------------");
        System.out.println();

    }

    @Override
    public void discount(String findName, int rate) {
        for (int i = 0; i < electArray.length - 1; i++) {
            if (electArray[i] != null) {
                if (electArray[i].getName().equals(findName)) {
                    electArray[i].setPrice(electArray[i].getPrice() - (int)( 0.01 * rate * electArray[i].getPrice()));
                }
            }
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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

    public int getElectType() {
        return electType;
    }

    public void setElectType(int electType) {
        this.electType = electType;
    }
}
