package chap07.poly.ex6;


public class ChildExample {
    public static void main(String[] args) {
        Parent parent = new Child();


        // 부모가 보유한 걸 가져옴
        parent.field1 = "data1";
        parent.method1();
        parent.method2();

        /* 부모에 없는 자식꺼는 못 가져옴
		parent.field2 = "data2";  //(불가능)
		parent.method3();         //(불가능)
		*/

        // 부모가된 자식을 다시 자식화, 자식이 자식 것을 가져옴
        Child child = (Child) parent;
        child.field2 = "yyy";  //(가능)
        child.method3();     //(가능)
        child.method1(); //부모에서 상속 받아서 가능
    }
}
