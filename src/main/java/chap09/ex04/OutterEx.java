package chap09.ex04;

public class OutterEx {
    public static void main(String[] args) {
        Outter outter = new Outter();
        Outter.Nested nested = outter.new Nested();  // Nested nested = new Nested();에 Outter.을 붙여서 생성
        nested.print();
        nested.method();
        outter.method();



    }
}
