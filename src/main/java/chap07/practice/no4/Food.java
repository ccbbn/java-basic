package chap07.practice.no4;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Food implements Order {

    public Food[] foodArray = new Food[50];
    Scanner scanner = new Scanner(System.in);


    int id;
    String name;
    int price;
    int stock;
    LocalDate made;
    LocalDate limitation;
    int foodType;

    public Food() {
    }

    public Food(int id, String name, int price, int stock, LocalDate made, LocalDate limitation, int foodType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.made = made;
        this.limitation = limitation;
        this.foodType = foodType;

    }

    @Override
    public void add() {
        int i = 0;
        foodArray[i++] = new Food(778978,"떡볶이",3000,100,LocalDate.now(),LocalDate.now().plusDays(30),2);
        foodArray[i++] = new Food(123978,"라볶이",4000,100,LocalDate.now(),LocalDate.now().plusDays(20),2);
        foodArray[i++] = new Food(123978,"소고기",50000,100,LocalDate.now(),LocalDate.now().plusDays(3),2);
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

        System.out.print("제조일자: ");
        LocalDate made = LocalDate.now();
        System.out.println(made);

        System.out.print("유통기한: ");
        LocalDate limitation = LocalDate.now().plusYears(1);
        System.out.println(limitation);

        System.out.println("-----입력완료-----");


        Food food = new Food(id, name, price, stock, made, limitation, Order.foodType);
        for (int i = 0; i <= foodArray.length; i++) {
            if (foodArray[i] == null) {
                foodArray[i] = food;
                break;
            }
        }

    }


    @Override
    public void change(String findName, String change) {
        for (int i = 0; i < foodArray.length - 1; i++) {
            if (foodArray[i] != null) {
                if (foodArray[i].getName().equals(findName)) {
                    foodArray[i].setName(change);


                }
            }
        }
    }


    @Override
    public void delete(String deleteName) {
        for (int i = 0; i < foodArray.length - 1; i++) {
            if (foodArray[i] != null) {
                if (foodArray[i].getName().equals(deleteName)) {
                    foodArray[i] = null;
                }
            }
        }
    }

    @Override
    public void find(String findName) {
        for (int i = 0; i < foodArray.length - 1; i++) {
            if (foodArray[i] != null) {
                if (foodArray[i].getName().equals(findName)) {
                    System.out.println("================이름이 " + findName + " 인 식품정보==============");
                    System.out.println("상품id : " + foodArray[i].getId());
                    System.out.println("음식 이름: " + foodArray[i].getName());
                    System.out.println("가격 : " + foodArray[i].getPrice());
                    System.out.println("제조일 : " + foodArray[i].made);
                    System.out.println("유통기한 : " + foodArray[i].limitation);
                }
            }
        }
    }


    @Override
    public void allList() {
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■식품목록■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println("1: 상품id | 2: 상품명 | 3: 가격 |   4: 제조일     |   5: 유통기한     ");
        System.out.println("==================================================================");

        for (int i = 0; i < foodArray.length - 1; i++) {
            if (foodArray[i] != null) {
                System.out.print(foodArray[i].getId());
                System.out.print("        ");
                System.out.print(foodArray[i].getName());
                System.out.print("        ");
                System.out.print(foodArray[i].getPrice());
                System.out.print("        ");
                System.out.print(foodArray[i].made);
                System.out.print("        ");
                System.out.println(foodArray[i].limitation);
            }
        }
                System.out.println("----------------------------식품 목록 끝---------------------------------");
                System.out.println();

    }


    @Override
    public void discount(String findName, int rate) {
        for (int i = 0; i < foodArray.length - 1; i++) {
            if (foodArray[i] != null) {
                if (foodArray[i].getName().equals(findName)) {
                    foodArray[i].setPrice(foodArray[i].getPrice() - (int)( 0.01 * rate * foodArray[i].getPrice()));
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

    public int getFoodType() {
        return foodType;
    }

    public void setFoodType(int foodType) {
        this.foodType = foodType;
    }
}
