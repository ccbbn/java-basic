package chap08.default_method;

public interface MyInterface {

    void method();


    // 기존에 method에 지장 안가게 새로 선언
    // 디퐅트 선언 없이 새로운 매소드(추상)를 추하가면
    // 구현 클래스에 반드시 오버라이드를 해야함
    // 하지만 디폴트를 선언한 메소드는
    // 구현 클래스에서 오버라이드가 선택사항임
    // 그래서 기존 메소드(추상)에 영향을 주지 않는 메소드를 생성임
    default void method2() {
        System.out.println("인터페이스의 디폴트 메소드 실행");
    }


}
