package chap08.default_method;

public class Excute {
    public static void main(String[] args) {
        MyInterface MyClassA = new MyClassA();
        MyClassA.method(); // MyClassA의 메소드
        MyClassA.method2(); // 인터페이스의 디폴트 메소드,, 어떤 메소드를 추가하고 싶을 때 다른 메소드들에 지장을 안줌,

        MyInterface MyClassB = new MyClassB();
        MyClassB.method(); // MyClassB의 메소드
        MyClassB.method2(); // 재정의 된 메소드

    }
}
