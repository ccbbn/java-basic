package chap09.ex04;

public class Outter {
    String field = "Outter - field";
    void method() {
        System.out.println("Outter - method");
    }

    ///////////////////중첩된 내부 클래스 시작/////////////////
    class Nested {
        String field = "Nested - field";
        void method() {
            System.out.println("Nested - method");
        }

        void print() {
            System.out.println(this.field);
            this.method();                          // Nested의 메서드

            System.out.println(Outter.this.field);
            Outter.this.method();                   // Outter의 메서드
            //바깥 클래스의 this///
        }

    ///////////////////중첩된 내부 클래스 끝////////////////////
    }
}
