package chap06.ex;

public class OOPExample {
    public static void main(String[] args) {

        // Human이라는 틀로 변수를 찍어냄
        Human human1;
        Human human2;
        Human human3;

        // human 변수를 초기화
        Human human4 = new Human();
        Human human5 = new Human();
        Human human6 = new Human();

        human4.name = "김지영";
        human5.name = "임종각";
        human6.name = "홍길동";

        System.out.println(human4.shopping("밥"));


        Member member = new Member();
        member.name = "홍길동";
        member.grade = Grade.GOLD;

        Item item = new Item();
        item.category = ItemCategory.ELECTRONICS;
        item.name = "레전드";
        item.stock = 3;
        item.des = "좋은 밥맛";


        Order order = member.order(item);
        if (order != null) {

            System.out.println("=====주문내역====");
            System.out.println("구매일자 : " + order.orderDate);
            System.out.println("구매자 : " + order.member.name);
            System.out.println("상품명 : " + order.item.name);
            System.out.println("=============");

        }
    }
}
