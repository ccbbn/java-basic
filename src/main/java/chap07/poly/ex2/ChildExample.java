package chap07.poly.ex2;

public class ChildExample {
    public static void main(String[] args) {

        //1. 다형성을 통해 부모 객체가 자식 객체를 가리킬 수 있음
        //2. 자식 객체는 부모 객체로 자동 형변환
        //3. 부모 객체일지라도 자식 객체를 가리킨다면 오버라이드된 자식을 소환함
        //4. 부모가 객체가 자식 객체를 가리킬 때, 부모 객체에 없는 메소드면 소환 불가


        Child child = new Child();

        Parent parent = child;

        parent.method1();

        parent.method2();

        //parent.method3();  (호출 불가능)
    }
}
