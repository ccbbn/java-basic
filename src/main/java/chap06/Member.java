package chap06;

import java.util.Date;

public class Member {
    String id;
    String  name;
    String pw;
    String addr;
    String phoneNumber;
    boolean agreeMessage;
    String[] shoppingList;
    String[] likesList;
    //enum
    Grade grade;

    Order order(Item item) {

        if(item.stock <= 0){
            System.out.println("품절되었습니다.");
            return null;
        }
        item.stock--;
        Order order = new Order();
        order.orderDate = new Date();
        order.member = this;
        order.orderPrice += item.price;
        order.item = item;

        return order;




    };

    void returnItem() {};

    void inquire() {};

    void post() {};


}
