package chap12generic.check.q3;

import chap07.poly.ex1.C;

public class ContainerEx {
    public static void main(String[] args) {

        Container<String, String> container1 = new Container<>();
        container1.set("홍길동", "도적");
        String name1 = container1.getKey();
        String job = container1.getValue();


        Container<String, Integer> container2 = new Container<>();
        container2.set("홍길동", 35);
        String name2 = container2.getKey();
        int age = container2.getValue();





    }
}
