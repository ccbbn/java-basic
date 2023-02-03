package chap08.default_method;

public class MyClassA implements MyInterface{
    @Override
    public void method() {
        System.out.println("mya에서 method 실행");
    }

    // 디폴트 메소드 method2는 오버라이드가 선택사항
}
