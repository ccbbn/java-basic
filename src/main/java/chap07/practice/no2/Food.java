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

    // 음식 검색 4
    public static void findFoodName(String pName) {
        int i = 0;
        System.out.println(pName + " 의 이름을 갖는 음식정보");
        while (foodArray[i] != null) {
            if (foodArray[i].getName().equals(pName)) {
                System.out.println("===============");
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
        if (Food.foodArray[0] != null) {
            System.out.println("1: 상품id | 2: 상품명 |   3: 제조일     |   4: 유통기한     ");
            System.out.println("=============================================================");
        } else {
            System.out.println("식품은 없음");
        }
        int j = 0;
        while (Food.foodArray[j] != null) {
            System.out.print(Food.foodArray[j].getId());
            System.out.print("        ");
            System.out.print(Food.foodArray[j].getName());
            System.out.print("        ");
            System.out.print(Food.foodArray[j].made);
            System.out.print("        ");
            System.out.println(Food.foodArray[j].limitation);
            j++;
        }


    }


}

