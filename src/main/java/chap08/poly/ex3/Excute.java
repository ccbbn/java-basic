package chap08.poly.ex3;

public class Excute {
    public static void main(String[] args) {

        C c = new ImpleC();
        B b = new ImpleC();
        A a = new ImpleC();
        ImpleC c1 = new ImpleC();

        //c에서 접근 가능 메소드
        c.methodB(); c.methodC(); c.methodA();
        //b에서 접근 가능 메소드 , 상속 생각해보기
        b.methodB();
        //a에서 접근 가능 메소드
        a.methodA();
        //c1에서 접근 가능 메소드
        c1.methodA(); c1.methodC(); c1.methodB(); // 오버라이드 된 애들
    }
}
