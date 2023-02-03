package chap08.default_method2;

public interface ChildInter3 extends ParentInter{
    @Override
    public void method2(); // 부모의 디폴트 매소드2를 상속받아서 추상메소드로 재정의함
    public void method3(); // 인터페이스 c3의 추상메소드

}
