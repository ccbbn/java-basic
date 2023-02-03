package chap08.default_method2;

public interface ParentInter {
    void method1();
    default void method2(){
        System.out.println("디폴트 메소드2");
    };

}
