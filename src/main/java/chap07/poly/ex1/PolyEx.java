package chap07.poly.ex1;

public class PolyEx {
    public static void main(String[] args) {

        B b = new B();
        C c = new C();
        D d = new D();
        E e = new E();

        // A타입으로 4가지 타입 받기
        // 자동 타입 변환

        A a1 = b;
        A a2 = c;
        A a3 = d;
        A a4 = e;

        B b1 = d;
        C c1 = e;


    }
}
