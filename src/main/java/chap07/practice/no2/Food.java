package chap07.practice.no2;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Food extends Product {

    static Food[] foodArray = new Food[100];
    static Scanner scanner = new Scanner(System.in);


    LocalDate made;
    LocalDate limitation;

    public Food(int id, String name, int price, int stock, LocalDate made, LocalDate limitation) {
        super(id, name, price, stock);
        this.made = made;
        this.limitation = limitation;
    }
    // 음식 입력 1
    public static void inputFood() {

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


            Food food = new Food(id, name, price, stock, made, limitation );
            for (int i = 0; i <= foodArray.length; i++) {
                if (foodArray[i] == null) {
                    foodArray[i] = food;
                    break;
                }
            }

        }

    // 음식 바꿈 2
    public static void changeFood(String pName1, String change1) {
        for (int i = 0; i < Food.foodArray.length - 1; i++) {
            if (foodArray[i] != null) {
                if (Food.foodArray[i].getName().equals(pName1)) {
                    Food.foodArray[i].setName(change1);
                }
            }
        }
    }

    // 음식 삭제 3
    public static void removeFood(String pName2) {
        for (int i = 0; i < foodArray.length - 1; i++) {
            if (foodArray[i].getName().equals(pName2)) {
                foodArray[i] = null;
                break;
            }
        }
    }

    // 음식 검색 4
    public static void findFoodName(String pName) {
        int i = 0;
        while (foodArray[i] != null) {
            if (foodArray[i].getName().equals(pName)) {
                System.out.println("================이름이 "+ pName + " 인 식품정보==============");
                System.out.println("상품id : " + foodArray[i].getId());
                System.out.println("가격 : " + foodArray[i].getPrice());
                System.out.println("제조일 : " + foodArray[i].made);
                System.out.println("유통기한 : " + foodArray[i].limitation);
                System.out.println();
            }
            i++;
        }
    }

    // 음식 정보 6
    public static void foodList() {
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■식품목록■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println("1: 상품id | 2: 상품명 |   3: 제조일     |   4: 유통기한     ");
        System.out.println("=============================================================");
        for (int i = 0; i < Food.foodArray.length - 1; i++) {
            if (Food.foodArray[i] != null) {
                System.out.print(Food.foodArray[i].getId());
                System.out.print("        ");
                System.out.print(Food.foodArray[i].getName());
                System.out.print("        ");
                System.out.print(Food.foodArray[i].made);
                System.out.print("        ");
                System.out.println(Food.foodArray[i].limitation);
            }
        }
        System.out.println("-------------------------식품 목록 끝--------------------------");
        System.out.println();

    }


    @Override
    public void reWrite() {

    }
}

