package chap08.default_method2;

public interface ChildInter2 extends ParentInter{
    @Override
    default void method2() {
        System.out.println("부모에서 상속받은 디폴트 메소드2를 재정의");
    }

    public void method3(); //인터페이스 c2의 추상메소드

}
