package chap06;

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




    }
}
